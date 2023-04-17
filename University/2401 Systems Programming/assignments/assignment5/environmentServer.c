#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <pthread.h>
#include <semaphore.h>
#include <sys/socket.h>
#include <netinet/in.h>

#include "simulator.h"

Environment    environment;  // The environment that contains all the robots



// Handle client requests coming in through the server socket.  This code should run
// indefinitiely.  It should repeatedly grab an incoming messages and process them. 
// The requests that may be handled are STOP, REGISTER, CHECK_COLLISION and STATUS_UPDATE.   
// Upon receiving a STOP request, the server should get ready to shut down but must
// first wait until all robot clients have been informed of the shutdown.   Then it 
// should exit gracefully.  
void *handleIncomingRequests(void *e) {
	srand(time(NULL));
	char   online = 1;
	int shutcounter = 0;
  	// ... ADD SOME VARIABLE HERE... //
	int                 serverSocket;
	struct sockaddr_in  serverAddr, clientAddr;
	int                 status, addrSize, bytesReceived;
	fd_set              readfds, writefds;
	int                 buffer[30];//char for stop
	int                 response[30];
	char		    responsesinglebyte[30];

   	
   	//
  	// Initialize the server
	// Create the server socket
	serverSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (serverSocket < 0) {
		printf("*** SERVER ERROR: Could not open socket.\n");
		exit(-1);
	}

	// Setup the server address
	memset(&serverAddr, 0, sizeof(serverAddr)); // zeros the struct
	serverAddr.sin_family = AF_INET;
	serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);
	serverAddr.sin_port = htons((unsigned short) SERVER_PORT);

	// Bind the server socket
	status = bind(serverSocket, (struct sockaddr *) &serverAddr, sizeof(serverAddr));
	if (status < 0) {
		printf("*** SERVER ERROR: Could not bind socket.\n");
		exit(-1);
	}
  	// Wait for clients now
	while (online) {
		// ... WRITE YOUR CODE HERE ... //
		FD_ZERO(&readfds);
		FD_SET(serverSocket, &readfds);
		FD_ZERO(&writefds);
		FD_SET(serverSocket, &writefds);
		status = select(FD_SETSIZE, &readfds, &writefds, NULL, NULL);
		if (status == 0) {
			// Timeout occurred, no client ready
		}else if (status < 0) {
			printf("*** SERVER ERROR: Could not select socket.\n");
			exit(-1);
		}else{
			addrSize = sizeof(clientAddr);
			bytesReceived = recvfrom(serverSocket, buffer, sizeof(buffer),0, (struct sockaddr *) &clientAddr, &addrSize);
			if (bytesReceived > 0) {
				buffer[bytesReceived] = '\0';
				//printf("sizeof%lu\n",sizeof(buffer));
				//printf("SERVER: Received client request: %s\n", buffer);
			}
			
			// If the client said to stop, then I'll stop myself
			if (buffer[0] ==  STOP){
				//printf("SERVER: Received client request: STOP\n");
				environment.shutDown = 1;
			}
			if(buffer[0] == REGISTER){
				//printf("SERVER: Received client request: REGISTER %d\n",buffer[0]);
				if(environment.numRobots < 20){
					Robot newRobot;
					int x,y,id,direction;
					x = rand()%571+15;
					y = rand()%571+15;
					direction = rand()%361-180;
					id = environment.numRobots;
					
					int overlaps = 1;
					while(overlaps == 1){
						overlaps = 0;//does 1 check, if collide then newxy,resets and goes back into while loop,else doesnt change find new values
						for(int i = 0;i<environment.numRobots;i++){
							int botx = environment.robots[i].x;//currx
							int boty = environment.robots[i].y;//curryofbot iteration
							if (sqrt(pow((botx-x), 2) + pow((boty-y),2) ) <= (2 * ROBOT_RADIUS)&& i != id){//if collides or overlaps then new rand x,y
								x = rand()%571+15;
								y = rand()%571+15;
								overlaps = 1;//goes back into for loop
								//printf("newxy cus overlapped");//debug
							}
						}
					}
					
					
					newRobot.x = x;
					newRobot.y = y;
					newRobot.direction = direction;
					environment.robots[id] = newRobot;
				
					environment.numRobots += 1;
	
					response[0] = OK;
					response[1] = id;
					response[2] = x;
					response[3] = y;
					response[4] = direction;
					
					//printf("\nSERVER: Sending command to client: OK %d\n",response[0]);
					sendto(serverSocket, response, sizeof(response), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
				}else{
					response[0] = NOT_OK;
					//printf("\nSERVER: Sending command to client: NOT OK %d\n",response[0]);
					sendto(serverSocket, response, sizeof(response), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
				}
					
			}
			if(buffer[0] == CHECK_COLLISION){
				//printf("SERVER: Received client request: CHECK_COLLISION %d\n",buffer[0]);
				if (environment.shutDown == 1){
					responsesinglebyte[0] = LOST_CONTACT;
					//printf("\nSERVER: Sending command to client: LOST CONTACT %d\n",responsesinglebyte[0]);

					sendto(serverSocket, responsesinglebyte, strlen(responsesinglebyte), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
					shutcounter ++;
					if (shutcounter == environment.numRobots){
						online = 0;
						break;
					}
				}
				
				int newx,newy;
				int currid,currx,curry,currdirection;
				currid = buffer[1];
				currx = buffer[2];
				curry = buffer[3];
				currdirection = buffer[4];

				/////////////////////////////////////////debug
				/*
				printf("server command = %d\n",buffer[0]);
				printf("server id = %d\n",buffer[1]);
				printf("server x = %d\n",buffer[2]);
				printf("server y = %d\n",buffer[3]);
				printf("server direction = %d\n",buffer[4]);
				*/
				////////////////////////////////////////
				
				newx = currx+ROBOT_SPEED*cos(currdirection*PI/180);
				newy = curry+ROBOT_SPEED*sin(currdirection*PI/180);
				//printf("newx = %d\n",newx);
				//printf("newy = %d\n",newy);
				
				int sendcollide = 0;
				
				if (newx <= 15 || newx >= 585 || newy <= 15 || newy >= 585){//out of bounds
					responsesinglebyte[0] = NOT_OK_BOUNDARY;
					//printf("\nSERVER: Sending command to client: NOT_OK_BOUNDARY %d\n",responsesinglebyte[0]);
					sendto(serverSocket, responsesinglebyte, strlen(responsesinglebyte), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
					
				}else{
				
					//bot-botcollision, checks every bot but itself if it will overlap
					//this bot-botcollision is wrong for some reason, this causes the bots to everntually get stuck turning on each other or the wall.cant figure out issue. no issue if removed and the only collision check is boundary
					for(int i = 0;i<environment.numRobots;i++){
						int botx = environment.robots[i].x;
						int boty = environment.robots[i].y;
						if (sqrt(pow((newx-botx), 2) + pow((newy-boty),2) ) <= (2 * ROBOT_RADIUS) && i != currid){
							sendcollide = 1;
							responsesinglebyte[0] = NOT_OK_COLLIDE;
							//printf("\nSERVER: Sending command to client: NOT_OK_COLLIDE %d\n",responsesinglebyte[0]);
							sendto(serverSocket, responsesinglebyte, strlen(responsesinglebyte), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
							
						}
					}
					
					//if doesnt hit wall or overlap send bad ok to move
					if(sendcollide == 0){
						responsesinglebyte[0] = OK;
						//printf("\nSERVER: Sending command to client: OK S%d\n",responsesinglebyte[0]);
						sendto(serverSocket, responsesinglebyte, strlen(responsesinglebyte), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));
					}
				}
			}
			if(buffer[0] == STATUS_UPDATE){
				environment.robots[buffer[1]].x = buffer[2];
				environment.robots[buffer[1]].y = buffer[3];
				environment.robots[buffer[1]].direction = buffer[4];//updates bot members
			}
				
				

		}

  	}
  	// ... WRITE ANY CLEANUP CODE HERE ... //
  	// Don't forget to close the sockets!
	close(serverSocket);
	printf("SERVER: Shutting down.\n");
	exit(0);
}

int main() {
	// So far, the environment is NOT shut down
	environment.shutDown = 0;
  
	// Set up the random seed
	srand(time(NULL));
	
	pthread_t handle;
	pthread_t draw;
	
	pthread_create(&handle,NULL,handleIncomingRequests,&environment);
	pthread_create(&draw,NULL,redraw,&environment);
	
	// Spawn an infinite loop to handle incoming requests and update the display
	pthread_join(handle,NULL);
	pthread_join(draw,NULL);
	// Wait for the update and draw threads to complete
}
