#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <math.h>
#define SERVER_PORT 6000

int prime(int n);
int main() {
  int                 serverSocket;
  struct sockaddr_in  serverAddr, clientAddr;
  int                 status, addrSize, bytesReceived;
  fd_set              readfds, writefds;
  char                buffer[30];
  char*               response = "OK";

 
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
  while (1) {
    FD_ZERO(&readfds);
    FD_SET(serverSocket, &readfds);
    FD_ZERO(&writefds);
    FD_SET(serverSocket, &writefds);
    status = select(FD_SETSIZE, &readfds, &writefds, NULL, NULL);
    if (status == 0) {
      // Timeout occurred, no client ready
    }
    else if (status < 0) {
      printf("*** SERVER ERROR: Could not select socket.\n");
      exit(-1);
    }
    else {
      addrSize = sizeof(clientAddr);
      bytesReceived = recvfrom(serverSocket, buffer, sizeof(buffer),
                               0, (struct sockaddr *) &clientAddr, &addrSize);
      if (bytesReceived > 0) {
        buffer[bytesReceived] = '\0';
        printf("SERVER: Received client request: %s\n", buffer);
      }
      // If the client said to stop, then I'll stop myself
      if (strcmp(buffer, "stop") == 0||strcmp(buffer, "done") == 0)
	break;

      if (prime(atoi(buffer))==1){
      		printf("Received number: %s is a prime",buffer);
		response = "number is a prime";
      }else{
      		printf("Received number: %s is not a prime",buffer);
      		response = "number is not a prime";
      }
      // Respond with an "response, if prime or not a prime number" message
      printf("\nSERVER: Sending \"%s\" to client\n", response);
      sendto(serverSocket, response, strlen(response), 0,(struct sockaddr *) &clientAddr, sizeof(clientAddr));

      
      
    }
  } 

  // Don't forget to close the sockets!
  close(serverSocket);
  printf("SERVER: Shutting down.\n");
}

int prime(int n) {
	int max = (int)sqrt(n);
	
	for (int i = 2; i <= max; i++){
		if (n % i == 0) {
			//printf("%ld is not prime\n", num);
			return 0;
		}
	}
	//printf("%ld is prime\n", num);
	return 1;
}
