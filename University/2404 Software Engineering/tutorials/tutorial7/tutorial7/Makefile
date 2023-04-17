objects = test.o Location.o StoreLocation.o

all: test

test: $(objects)
	g++ -o test $(objects)

test.o: test.cc Location.h  StoreLocation.h 
	g++ -c test.cc

StoreLocation.o: StoreLocation.h StoreLocation.cc Location.h
	g++ -c StoreLocation.cc
	
Location.o: Location.cc Location.h 
	g++ -c Location.cc

clean:
	rm -f test *.o	

