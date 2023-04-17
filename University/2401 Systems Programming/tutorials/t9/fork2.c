#include "stdio.h"
#include "unistd.h"
#include <sys/types.h>
#include <sys/wait.h>
int main(int argc, char *argv[])
{
	char *param[5];
	param[0] = "morphed";
	param[1] = "55";
	param[2] = "Second Command Parameter";
	param[3] = "5";
	param[4] = NULL;
	int status;
	int rc;
	int pid = fork();
	if (pid == 0) {
		// child process instructions
		
		rc = execv("./morphed",param);
		printf(" This should not be printed \n"); // this should not be executed because the child is executing a new program
		// 
	} else {
		// parent process instructions
		wait(&status);
		printf("Parent program \n");
		printf("\treturn code %d\n",rc);
	}
}
