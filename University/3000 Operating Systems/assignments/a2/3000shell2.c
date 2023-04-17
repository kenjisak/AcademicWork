/* 3000shell2.c */

/* variant of 3000shell.c from here:
   https://homeostasis.scs.carleton.ca/~soma/os-2019f/code/3000shell.c
 */
   
/* This version is under GPLv3, copyright 2022, Anil Somayaji */
/* You really shouldn't be incorporating parts of this in any other code,
   it is meant for teaching, not production */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <ctype.h>
#include <fcntl.h>
#include <signal.h>
#include <pwd.h>

#define BUFFER_SIZE 1<<16
#define ARR_SIZE 1<<16
#define COMM_SIZE 32

const char *proc_prefix = "/proc";

void parse_args(char *buffer, char** args, 
                size_t args_size, size_t *nargs)
{
        char *buf_args[args_size]; /* You need C99 */
        char **cp, *wbuf;
        size_t i, j;
        
        wbuf=buffer;
        buf_args[0]=buffer; 
        args[0] =buffer;
        
        for(cp=buf_args; (*cp=strsep(&wbuf, " \n\t")) != NULL ;){
                if ((*cp != NULL) && (++cp >= &buf_args[args_size]))
                        break;
        }
        
        for (j=i=0; buf_args[i]!=NULL; i++){
                if (strlen(buf_args[i]) > 0)
                        args[j++]=buf_args[i];
        }
        
        *nargs=j;
        args[j]=NULL;
}

void become(char *username)//change this for new uid arg passed
{
        int result;
        struct passwd *pw_entry;

        if(isdigit(username[0])){//if first char is digit then 
                pw_entry = getpwuid(atoi(username));//uses student as username since uid is given
        }else{
                pw_entry = getpwnam(username);//finds given username
        }
        
        if (pw_entry == NULL) {
                fprintf(stderr, "Could not find user %s.\n", username);
                exit(-2);
        }

        result = setgid(pw_entry->pw_gid);
        if (result != 0) {
                fprintf(stderr, "Failed to change to gid %d\n",
                        pw_entry->pw_gid);
                exit(-3);
        }
        
        if(isdigit(username[0])){//if input is a digit then uid is given
                result = setuid(atoi(username));//set uid to converted input
                if (result != 0) {
                        fprintf(stderr, "Failed to change to uid %d\n",
                                atoi(username));
                        exit(-4);
                }
        }else{
                result = setuid(pw_entry->pw_gid);//otherwise username is given
                if (result != 0) {
                        fprintf(stderr, "Failed to change to uid %d\n",
                                pw_entry->pw_gid);
                        exit(-4);
                }
        }
        
}

void find_binary(char *name, char *path, char *fn, int fn_size) {
        char *n, *p;
        int r, stat_return;

        struct stat file_status;

        if (name[0] == '.' || name[0] == '/') {
                strncpy(fn, name, fn_size);
                return;
        }
        
        p = path;
        while (*p != '\0') {       
                r = 0;
                while (*p != '\0' && *p != ':' && r < fn_size - 1) {
                        fn[r] = *p;
                        r++;
                        p++;
                }

                fn[r] = '/';
                r++;
                
                n = name;
                while (*n != '\0' && r < fn_size) {
                        fn[r] = *n;
                        n++;
                        r++;
                }
                fn[r] = '\0';

                
                stat_return = stat(fn, &file_status);

                if (stat_return == 0) {
                        return;
                }

                if (*p != '\0') {
                        p++;
                }
        }
}

void setup_comm_fn(char *pidstr, char *comm_fn)
{
        char *c;

        strcpy(comm_fn, proc_prefix);
        c = comm_fn + strlen(comm_fn);
        *c = '/';
        c++;
        strcpy(c, pidstr);
        c = c + strlen(pidstr);
        strcpy(c, "/comm");
}

void signal_handler(int the_signal)
{
        int pid, status;

        if (the_signal == SIGHUP) {
                fprintf(stderr, "Received SIGHUP.\n");
                return;
        }
        
        if (the_signal != SIGCHLD) {
                fprintf(stderr, "Child handler called for signal %d?!\n",
                        the_signal);
                return;
        }

        pid = wait(&status);

        if (pid == -1) {
                /* nothing to wait for */
                return;
        }
        
        if (WIFEXITED(status)) {
                fprintf(stderr, "\nProcess %d exited with status %d.\n",
                        pid, WEXITSTATUS(status));
        } else {
                fprintf(stderr, "\nProcess %d aborted.\n", pid);
        }
}

void run_program(char *args[], int background, char *stdin_fn,char *stdout_fn,char *stderr_fn,
                 char *path, char *envp[], char *new_user)//change this so that new arg is passed
{
        pid_t pid;
        int fd, *ret_status = NULL;
        char bin_fn[BUFFER_SIZE];

        pid = fork();
        if (pid) {
                if (background) {
                        fprintf(stderr,
                                "Process %d running in the background.\n",
                                pid);
                } else {
                        pid = wait(ret_status);
                }
        } else {
                if (new_user) {
                        become(new_user);//change this for new arg
                } else {
                        setegid(getgid());
                        seteuid(getuid());
                }
                
                find_binary(args[0], path, bin_fn, BUFFER_SIZE);

                if (stdin_fn != NULL) {
                        fd = open(stdin_fn, O_RDONLY);
                        dup2(fd, 0);
                        close(fd);
                }

                if (stdout_fn != NULL) {
                        fd = creat(stdout_fn, 0666);
                        dup2(fd, 1);
                        close(fd);
                }

                if (stderr_fn != NULL) {
                        fd = creat(stderr_fn, 0666);
                        dup2(fd, 2);
                        close(fd);
                }
                
                if (execve(bin_fn, args, envp)) {
                        puts(strerror(errno));
                        exit(127);
                }
        }
}

void pinfo(void)
{
        printf("uid=%d, euid=%d, gid=%d, egid=%d\n",
               getuid(), geteuid(), getgid(), getegid());
}

void prompt_loop(char *username, char *path, char *envp[])
{
        char buffer[BUFFER_SIZE];
        char *all_args[ARR_SIZE];
        char **args;
        
        int background;
        size_t nargs;
        char *s;
        int i, j;
        char *stdin_fn, *stdout_fn, *stderr_fn,*new_user;
        
        while(1){
                printf("%s $ ", username);
                s = fgets(buffer, BUFFER_SIZE, stdin);
                
                if (s == NULL) {
                        /* we reached EOF */
                        printf("\n");
                        exit(0);
                }
                
                parse_args(buffer, all_args, ARR_SIZE, &nargs); 
                
                if (nargs==0) continue;

                args = all_args;
                
                if (!strcmp(args[0], "exit")) {
                        exit(0);
                }
                
                if (!strcmp(args[0], "pinfo")) {
                        pinfo();
                        continue;
                }

                new_user = NULL;                       
                if (!strcmp(args[0], "become")) {
                        if (nargs > 2) {
                                new_user = args[1];//new user is 2nd arg
                                args = args + 2;//args is args + 2?
                                nargs = nargs - 2;//number of args - 2 which is 1?
                        } else {
                                fprintf(stderr,
                                        "ERROR: become needs a username "
                                        "and a command\n");
                        }
                }                
                
                background = 0;            
                if (strcmp(args[nargs-1], "&") == 0) {
                        background = 1;
                        nargs--;
                        args[nargs] = NULL;
                }
                stdin_fn = NULL;
                stdout_fn = NULL;
                stderr_fn = NULL;
                if (strcmp(args[0], "background") == 0) {//checks if first args is background if it is then
                        fprintf(stdout,"heres background working\n");
                        if (nargs > 4) {//background input.txt ouput.txt error.txt ls
                                background = 1;
                                stdin_fn = args[1];
                                stdout_fn = args[2];
                                stderr_fn = args[3];

                                args = args + 4;
                                nargs = nargs - 4;
                        } else {
                                fprintf(stderr,
                                        "ERROR: background needs 4 other arguements: stdin , stdout, stderr, program\n");
                        }
                }

                for (i = 1; i < nargs; i++) {//checks if it needs to output the file
                        if (args[i][0] == '>') {
                                stdout_fn = args[i];
                                stdout_fn++;
                                printf("Set stdout to %s\n", stdout_fn);
                                for (j = i; j < nargs - 1; j++) {
                                        args[j] = args[j+1];
                                }
                                nargs--;
                                args[nargs] = NULL;
                                break;
                        }
                }
                run_program(args, background, stdin_fn, stdout_fn, stderr_fn , path, envp, new_user);
        }    
}

int main(int argc, char *argv[], char *envp[])
{
        struct sigaction signal_handler_struct;
                
        char *username;
        char *default_username = "UNKNOWN";
        
        char *path;
        char *default_path = "/usr/bin:/bin";
        
        memset (&signal_handler_struct, 0, sizeof(signal_handler_struct));
        signal_handler_struct.sa_handler = signal_handler;
        signal_handler_struct.sa_flags = SA_RESTART;
        
        if (sigaction(SIGCHLD, &signal_handler_struct, NULL)) {
                fprintf(stderr, "Couldn't register SIGCHLD handler.\n");
        }
        
        if (sigaction(SIGHUP, &signal_handler_struct, NULL)) {
                fprintf(stderr, "Couldn't register SIGHUP handler.\n");
        }
        
        username = getenv("USER");
        if (!username) {
                username = default_username;
        }

        path = getenv("PATH");
        if (!path) {
                path = default_path;
        }

        prompt_loop(username, path, envp);
        
        return 0;
}
