/* 3000userlogin.c */
/* version 0.1 */

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <pwd.h>

int main(int argc, char *argv[])
{
        int result;
        char *shell_argv[3];
        char *username;
        extern char **environ;
        struct passwd *pw_entry;
                
        if (argc < 2) {
                fprintf(stderr, "Usage: %s <username>\n", argv[0]);
                exit(-1);
        }

        printf("uid=%d, euid=%d, gid=%d, egid=%d\n",
               getuid(), geteuid(), getgid(), getegid());

        username = argv[1];
        
        pw_entry = getpwnam(username);
        
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

        result = setuid(pw_entry->pw_uid);
        if (result != 0) {
                fprintf(stderr, "Failed to change to uid %d\n",
                        pw_entry->pw_uid);
                exit(-4);
        }

        result = chdir(pw_entry->pw_dir);
        if (result != 0) {
                fprintf(stderr, "Failed to change to home dir %s\n",
                        pw_entry->pw_dir);
                exit(-5);
        }

        shell_argv[0] = "bash";
        shell_argv[1] = "--login";
        shell_argv[2] = NULL;

        clearenv();
        setenv("USERNAME", pw_entry->pw_name, 1);
        setenv("PATH", "/usr/bin:/bin", 1);
        setenv("SHELL", "/bin/bash", 1);
        setenv("HOME", pw_entry->pw_dir, 1);
        setenv("COMP3000", "yes", 1);
        
        printf("heres the password: %s",pw_entry->pw_passwd);
        execve("/bin/bash", shell_argv, environ);
        
        fprintf(stderr, "Failed to exec bash\n");
        
        return -6;
}
