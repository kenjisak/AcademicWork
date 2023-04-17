all: test
	
test: test.cc Queue.o Student.o 
	g++ -o test test.cc Queue.o Student.o 
	
Queue.o:	Queue.h Queue.cc Student.h
	g++ -c Queue.cc 

Student.o:	Student.h Student.cc
	g++ -c Student.cc
	
clean:
	rm -f test *.o
