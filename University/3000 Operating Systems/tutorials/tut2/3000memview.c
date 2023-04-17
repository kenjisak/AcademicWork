#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

char *gmsg = "Global Message";//data

const int buffer_size = 100;//data

int main(int argc, char *argv[], char *envp[])
{
        char *lmsg = "Local Message";
        char *buf[buffer_size];//
        int i;//stack
        
        printf("Memory report\n");//code + constant
        printf("argv:      %lx\n", (unsigned long) argv);//stack
        printf("argv[0]:   %lx\n", (unsigned long) argv[0]);//stack
        printf("envp:      %lx\n", (unsigned long) envp);//stack
        printf("envp[0]:   %lx\n", (unsigned long) envp[0]);//stack

        printf("lmsg:      %lx\n", (unsigned long) lmsg);//heap shouldnt this be stack cus local ptr?
        printf("&lmsg:     %lx\n", (unsigned long) &lmsg);//stack
        printf("gmsg:      %lx\n", (unsigned long) gmsg);//heap
        printf("&gmsg:     %lx\n", (unsigned long) &gmsg);//stack

        printf("main:      %lx\n", (unsigned long) &main);//heap

        printf("sbrk(0):   %lx\n", (unsigned long) sbrk(0));//heap
        printf("&buf:      %lx\n", (unsigned long) &buf);//stack

        for (i = 0; i<buffer_size; i++) {
                buf[i] = (char *) malloc(132000);//heap
        }
        
        printf("buf[0]:    %lx\n", (unsigned long) buf[0]);//heap
        printf("sbrk(0):   %lx\n", (unsigned long) sbrk(0));//heap
        
        return 0;
}
