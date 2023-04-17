/* 3000test.c */
/* v1 Oct. 1, 2017 */
/* Licenced under the GPLv3, copyright Anil Somayaji */
/* You really shouldn't be incorporating parts of this in any other code,
   it is meant for teaching, not production */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>
#include <sys/resource.h>
void report_error(char *error)
{
        fprintf(stderr, "Error: %s\n", error);

        exit(-1);
}
long get_mem_usage(){
        struct rusage myusage;
        getrusage(RUSAGE_SELF, &myusage);
        return myusage.ru_maxrss;
}
int main(int argc, char *argv[])
{
        struct stat statbuf;
        char *fn;
        int fd;
        size_t len, i, count,readthis;
        
        char *data;

        char *linkname;
        
        long baseline = get_mem_usage();

        if (argc < 2) {
                if (argc < 1) {
                        report_error("no command line");
                        fprintf(stderr, "Usage: %s <file>\n", argv[0]); 
                } else {
                        report_error("Not enough arguments");
                        fprintf(stderr, "Usage: %s <file>\n", argv[0]); 
                }
        }

        fn = argv[1];

        if (lstat(fn, &statbuf)) {
                report_error(strerror(errno));
        }
        printf("usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
        sleep(3);
        len = statbuf.st_size;
        
        if (S_ISREG(statbuf.st_mode) && strcmp(fn,"text.txt") == 0){
                printf("no perms\n");
        }else{
                printf("File %s: \n", fn);
                printf("   inode %ld\n", statbuf.st_ino);
                printf("  length %ld\n", len);

                printf("after print usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
                sleep(3);

                if(S_ISLNK(statbuf.st_mode) && fn[0] == '/'){//if path name is given
                linkname = malloc(statbuf.st_size + 1);
                readthis = readlink(fn,linkname,statbuf.st_size + 1);
                linkname[statbuf.st_size] = '\0';

                printf("'%s' points to '%s'\n", fn, linkname);
                }

                if (S_ISREG(statbuf.st_mode)) {//if regular file then count the a
                        fd = open(fn, O_RDONLY);
                        if (fd == -1) {
                                report_error(strerror(errno));
                        }
                        printf("file open usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
                        sleep(3);
                        data = (char *) mmap(NULL, len,
                                        PROT_READ, MAP_SHARED, fd, 0);
                        if (data == MAP_FAILED) {
                                report_error(strerror(errno));
                        }
                        printf("mmap usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
                        sleep(3);

                        count = 0;
                        for (i=0; i<len; i++) {
                                if (data[i] == 'a') {
                                        count++;
                                }
                        }

                        printf(" a count %ld\n", count);
                        
                        printf("a count usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
                        sleep(3);

                        if (munmap(data, len) == -1) {
                                report_error(strerror(errno));                        
                        }
                        close(fd);
                }
        }
        printf("end total usage: %ld + %ld \n",baseline,get_mem_usage() - baseline);
        return 0;
}
