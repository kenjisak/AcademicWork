#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#include "simulator.h"


int main() {
	// ... ADD SOME VARIABLES HERE ... //
	int                 clientSocket, addrSize, bytesReceived;
	struct sockaddr_in  clientAddr;
	int                buffer[30];   // set to stop command char as single byte
	buffer[0] = STOP;
	// Register with the server
	// ... WRITE SOME CODE HERE ... //
	// Create socket
	clientSocket = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (clientSocket < 0) {
		printf("*** STOP ERROR: Could open socket.\n");
		exit(-1);
	}
	// Setup address 
	memset(&clientAddr, 0, sizeof(clientAddr));
	clientAddr.sin_family = AF_INET;
	clientAddr.sin_addr.s_addr = inet_addr(SERVER_IP);
	clientAddr.sin_port = htons((unsigned short) SERVER_PORT);
	
	// Send command string to server
	// ... WRITE SOME CODE HERE ... //
	//strcpy(buffer, stopcmd);
	//printf("sizeof%zu\n", sizeof(buffer));
	printf("STOP: Sending %d to server.\n",buffer[0]);
	sendto(clientSocket, buffer, sizeof(buffer), 0,(struct sockaddr *) &clientAddr,sizeof(clientAddr));

	// ... WRITE ANY CLEANUP CODE HERE ... //
  	// Don't forget to close the sockets!
	close(clientSocket);  // Don't forget to close the socket !
	printf("STOP: Shutting down.\n");
}
