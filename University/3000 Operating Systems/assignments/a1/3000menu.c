/* 3000menu.c */
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

extern char **environ;

char *menu[] = {
        "/usr/bin/ls",
        "/usr/bin/whoami",
        "/usr/bin/top",
        "QUIT",
        NULL
};

int QUIT = 3;

void run_program(int choice)
{
        pid_t pid;
        int status;
        
        printf("Running %s\n", menu[choice]);

        pid = fork();

        if (pid == 0) {
                menu[choice+1] = NULL;
                execve(menu[choice], menu + choice, environ);
                exit(-1);
        } else {
                pid = wait(&status);
        }
        
        return;
}

int choose_program(void)
{
        int i = 0;
        int choice;
        char *input = NULL;
        size_t result, n = 0;

        printf("\nChoose a program to run:\n\n");
        
        while (menu[i] != NULL) {
                printf("%d. %s\n", i + 1, menu[i]);
                i++;
        }

        printf("\nYour choice? ");
        
      

        if ((choice > 0) && (choice <= i)) {
                return choice - 1;
        } else {
                return -1;
        }
}

int main()
{
        int program;

        while (1) {
                program = choose_program();

                if (program == QUIT) {
                        return 0;
                }
                
                if (program != -1) {
                        run_program(program);
                }
        }
}
