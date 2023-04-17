all: test
	
test: test.cc Episode.o HeapArrays.o StackArrays.o
	g++ -o test test.cc Episode.o HeapArrays.o StackArrays.o
	
StackArrays.o:	StackArrays.h StackArrays.cc 
	g++ -c StackArrays.cc 
	
HeapArrays.o:	HeapArrays.h HeapArrays.cc 
	g++ -c HeapArrays.cc 

Episode.o:	Episode.h Episode.cc
	g++ -c Episode.cc
	
clean:
	rm -f test *.o
