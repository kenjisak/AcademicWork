

#include "stdio.h"
#include "stdlib.h"
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
int main()
{ 
    int pid,cpid;
    int status;
    
    printf("Ready to fork...\n"); 
    pid = fork();	// create a clone
   
   	if (pid == 0) {
// child process instructions

		printf("Child process pid=%d parent process id=%d\n",getpid(), getppid()); 
		printf("Child has returned the value %d \n",WEXITSTATUS(status)); 
		return(55);
	} else if (pid > 0) {
// parent process instructions
		cpid = wait(&status);
		printf("\t Parent process pid=%d child process id=%d wait process id=%d \n",getpid(), pid, cpid);
		printf("\t Parent has returned the value %d \n",WIFEXITED(status)); 
		return(0);
	} else {
// pid < 0 – an error occurred during the form operation
		printf("\t ERROR - parent process pid=%d could not fork a child process \n",getpid());
		return(1);
	}
    /*
    printf("Fork returned %d\n",pid); 
    
	
    for (i = 0; i < 3; i++){
        printf("%d: in for loop \n",pid);
        sleep(1);
        i++;
    }
    */

}

