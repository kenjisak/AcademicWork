all: a1-global

a1-global: a1-global.cc Student.o Room.o Date.o Reservation.o Library.o
	g++ -o a1-global a1-global.cc Student.o Room.o Date.o Reservation.o Library.o

Student.o: Student.h Student.cc
	g++ -c Student.cc

Room.o: Room.h Room.cc
	g++ -c Room.cc

Date.o: Date.h Date.cc
	g++ -c Date.cc

Reservation.o: Reservation.h Reservation.cc
	g++ -c Reservation.cc

Library.o: Library.h Library.cc
	g++ -c Library.cc

clean:
	rm -f a1-global *.o
