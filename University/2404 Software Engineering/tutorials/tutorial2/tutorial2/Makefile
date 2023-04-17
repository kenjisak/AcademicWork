all: p1

p1: main.o Character.o battle.o
	g++ -o p1 main.o Character.o battle.o
main.o: main.cc Character.h battle.h 
	g++ -c main.cc
Character.o: Character.h Character.cc
	g++ -c Character.cc
battle.o: battle.h battle.cc
	g++ -c battle.cc

clean:
	rm -f main.o Character.o battle.o p1
