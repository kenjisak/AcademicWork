Kenji Isak Laguan
101160737

a1-global.cc
- tests all functions from all headers listed below 
Student.cc
- student class with name and number elements 
- has constructors setters and getters for the object and a lessthan func to determine which name is earlier alphabetically
Student.h
- header file with declarations of functions and member variables for its class
Room.cc
- room class with name ,capacity,num of computers, and if the room has a whiteboard
- has constructors setters and getters for the object 
- has lessthan func to determine which name is earlier alphabetically
- has meetscriteria func to determine if the student reserving a specific room has its criteria requested
Room.h
- header file with declarations of functions and member variables for its class
Date.cc
- date class with member variables suited to time and duration of staying in a room
- has constructors setters and getters for the object 
- has lessthan func to determine which name is earlier alphabetically
- has overlaps func to see if 2 dates overlap each other when trying to book a room
Date.h
- header file with declarations of functions and member variables for its class
Reservation.cc
- reservation class with pointers to objects like student, room, and date
- has constructors destructor setters and getters for the object 
- has lessthan func to determine which date is earlier than another
- has overlaps func to see if 2 dates overlap each other when trying to book a room and is utilizing the overlaps function from date class
Reservation.h
- header file with declarations of functions and member variables for its class
Library.h
- header file with declarations of functions and member variables for its class
Library.cc
- has array of pointers for students rooms and reservations
- has constructors destructor getters for the object
- acts as a library software for booking rooms
Makefile
- compiles all these files together into one executable to run