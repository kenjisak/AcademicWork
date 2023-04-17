

#include "stdio.h"
#include "stdlib.h"
#include <unistd.h>
#include <sys/types.h>
 #include <sys/wait.h>
 
int main()
{ 
    int pid;
    int i=0;
    int pid2;
    printf("Ready to fork...\n"); 
    pid=fork();	// create a clone
    pid=fork();
    if(pid == 0){
    	
    	printf("child1 after fork()\n"); 
    }else if(pid>0){
    	wait(NULL);
    	printf("parent1 after fork()\n"); 
    }
    

}

