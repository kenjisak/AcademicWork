objects = test.o Part.o Date.o 

all: test

test: $(objects)
	g++ -o test $(objects)

test.o: test.cc Date.h Part.h
	g++ -c test.cc 

Part.o: Part.h Part.cc
	g++ -c Part.cc
	
Date.o: Date.cc Date.h
	g++ -c Date.cc
	

clean:
	rm -f test *.o	

