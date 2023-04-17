
myExec: main.o person.o mystat.o
	gcc -o myExec main.o person.o mystat.o
 
person.o:person.h person.c mystat.h
	gcc -c person.c
clean:
	rm -f main.o person.o mystat.o myExec
