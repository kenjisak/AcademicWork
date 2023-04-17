#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <math.h>
#include <time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#include "simulator.h"


// This is the main function that simulates the "life" of the robot
// The code will exit whenever the robot fails to communicate with the server
int main() {
	// ... ADD SOME VARIABLE HERE ... //
	int                 clientSocket, addrSize, bytesReceived;
	struct sockaddr_in  clientAddr;
	int                buffer[30] ;   
	char		   checkcollreceive[30];			
	buffer[0] = REGISTER;
	Robot robocop;
	int roboid;
	int turndirection;
	// Set up the random seed
	srand(time(NULL));

	// Register with the server
	// Create socket
	clientSocket = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (clientSocket < 0) {
		printf("*** STOP ERROR: Could open socket.\n");
		exit(-1);
	}
	//set up address
	memset(&clientAddr, 0, sizeof(clientAddr));
	clientAddr.sin_family = AF_INET;
	clientAddr.sin_addr.s_addr = inet_addr(SERVER_IP);
	clientAddr.sin_port = htons((unsigned short) SERVER_PORT);
	
	
	
	
	// Send register command to server.  Get back response data
	// and store it.   If denied registration, then quit.
	//printf("ROBOT CLIENT: Sending command to server : REQUEST %d\n",buffer[0]);
	sendto(clientSocket, buffer, sizeof(buffer), 0, (struct sockaddr *) &clientAddr, sizeof(clientAddr));

	// Get response from server, should be "OK"
	addrSize = sizeof(clientAddr);
	bytesReceived = recvfrom(clientSocket, buffer, 30 ,0,(struct sockaddr *) &clientAddr, &addrSize);
	buffer[bytesReceived] = 0; // put a 0 at the end so we can display the string
	//printf("ROBOT CLIENT: Got back response \"%s\" from server.\n", buffer);
	if (buffer[0]==OK){
		//printf("ROBOT CLIENT: Received server response: OK %d\n",buffer[0]);
		//ok continue to while loop 
		roboid = buffer[1];//initilizes robot starting members
		robocop.x = buffer[2];
		robocop.y = buffer[3];
		robocop.direction = buffer[4];
		//////////////////////////////////////////debug
		/*
		printf("robocop id = %d\n",buffer[1]);
		printf("robocop x = %d\n",buffer[2]);
		printf("robocop y = %d\n",buffer[3]);
		printf("robocop direction = %d\n",buffer[4]);
		*/
		///////////////////////////////////////////////
		// Go into an infinite loop exhibiting the robot behavior
		
		while (1) {
			
			// Check if can move forward
			////////////////////////////////////
			/*
			printf("check id = %d\n",roboid);
			printf("check x = %f\n",robocop.x);
			printf("check y = %f\n",robocop.y);
			printf("check direction = %d\n",robocop.direction);
			*/
			////////////////////////////////////////////
			
			
			
			buffer[0] = CHECK_COLLISION; 
			buffer[1] = roboid;
			buffer[2] = robocop.x;
			buffer[3] = robocop.y;
			buffer[4] = robocop.direction;
			/////////////////////////////////////////debug
			/*
			printf("check id = %d\n",buffer[1] );
			printf("check x = %d\n",buffer[2]);
			printf("check y = %d\n",buffer[3]);
			printf("check direction = %d\n",buffer[4]);
			*/
			/////////////////////////////////////////////
			//send check collcmd plus data
 			sendto(clientSocket, buffer, sizeof(buffer), 0, (struct sockaddr *) &clientAddr, sizeof(clientAddr));

			// Get response from server as single byte
			//addrSize = sizeof(clientAddr);
			bytesReceived = recvfrom(clientSocket, checkcollreceive, 30 ,0,(struct sockaddr *) &clientAddr, &addrSize);
			checkcollreceive[bytesReceived] = 0; // put a 0 at the end so we can display the string
			
			// If ok, move forward	
			if(checkcollreceive[0] == OK){
				//set new x,y aka move forward
				//int newx,newy;
				//newx = 
				//newy = 
				robocop.x = robocop.x+ROBOT_SPEED*cos(robocop.direction*PI/180);
				robocop.y = robocop.y+ROBOT_SPEED*sin(robocop.direction*PI/180);//update bot in client
				turndirection = 0;
			// Otherwise, we could not move forward, so make a turn.
			}else if(checkcollreceive[0] == NOT_OK_COLLIDE || checkcollreceive[0] == NOT_OK_BOUNDARY){
				// If we were turning from the last time we collided, keep
				// turning in the same direction, otherwise choose a random 
				// direction to start turning.

				int tempdirection;
				if (turndirection == 0){
					int randnumlr = rand()%2;
					if (randnumlr == 0){//ccw
						tempdirection = robocop.direction + ROBOT_TURN_ANGLE;
						if (tempdirection > 180){
							tempdirection = tempdirection - 360;
						}
						turndirection = 1;
					}else if(randnumlr == 1){//cw
						tempdirection = robocop.direction - ROBOT_TURN_ANGLE;
						if (tempdirection < (-180)){
							tempdirection = tempdirection + 360;
						}
						turndirection = 2;
					}
				}else if(turndirection == 1){
					tempdirection = robocop.direction + ROBOT_TURN_ANGLE;
					if (tempdirection > 180){
						tempdirection = tempdirection - 360;
					}
					turndirection = 1;
				}else if(turndirection == 2){
					tempdirection = robocop.direction - ROBOT_TURN_ANGLE;
					if (tempdirection < (-180)){
						tempdirection = tempdirection + 360;
					}
					turndirection = 2;
				}
				robocop.direction = tempdirection;
			}else if(checkcollreceive[0] == LOST_CONTACT){
				close(clientSocket);  // Don't forget to close the socket !
		      		//printf("ROBOT CLIENT: Received server response: LOST CONTACT %d\n",checkcollreceive[0]);
				//printf("ROBOT CLIENT: Shutting down STOP initiated.\n");
				exit(0);
			}
				
			// Send update to server
			buffer[0] = STATUS_UPDATE; 
			buffer[1] = roboid;
			buffer[2] = robocop.x;
			buffer[3] = robocop.y;
			buffer[4] = robocop.direction;
 			sendto(clientSocket, buffer, sizeof(buffer), 0, (struct sockaddr *) &clientAddr, sizeof(clientAddr));
			/////////////////////////////////////////////debug
			/*
			printf("status id = %d\n",buffer[1]);
			printf("status x = %d\n",buffer[2]);
			printf("status y = %d\n",buffer[3]);
			printf("status direction = %d\n",buffer[4]);
			*/
			//////////////////////////////////////////////////
			
			// Uncomment line below to slow things down a bit 
			usleep(1000);
			
		
		}	
			
	}else if(buffer[0] == NOT_OK){
      		close(clientSocket);  // Don't forget to close the socket !
      		//printf("ROBOT CLIENT: Received server response: NOT OK %d\n",buffer[0]);
		//printf("ROBOT CLIENT: Shutting down, Max number of robots reached.\n");
		exit(0);
	}
}

