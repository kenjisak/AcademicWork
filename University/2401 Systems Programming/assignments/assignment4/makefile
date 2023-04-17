headers = obstacles.h display.h

all: testplan testbig pathmain util 
	gcc -o -lX11 plannerTester plannerTester.o display.o
	gcc -o -lX11 bigEnvironment bigEnvironment.o display.o
	gcc -o -lX11 pathPlanner pathPlanner.o display.o
testplan: plannerTester.c $(headers)
	gcc -c -lX11 plannerTester.c
testbig: bigEnvironment.c $(headers)
	gcc -c -lX11 bigEnvironment.c
pathmain: pathPlanner.c $(headers)
	gcc -c -lX11 pathPlanner.c
util: display.c $(headers)
	gcc -c -lX11 display.c
clean:
	rm -f plannerTester.o display.o plannerTester
	rm -f bigEnvironment.o display.o bigEnvironment
	rm -f pathPlanner.o display.o pathPlanner
