Kenji Isak Laguan
101160737

defs.h
- header file with declarations of member variables used for multiple classes
main.cc 
- launches test control to start testing this assignment
Makefile
- compiles all these files together into one executable to run
Control.cc
- Provides a test framework for the Airline.
Control.h 
- header file with declarations of functions and member variables for its class
View.cc
- Collects user input and provides system output.
View.h 
- header file with declarations of functions and member variables for its class

Date.cc
- Stores information of a date.
Date.h 
- header file with declarations of functions and member variables for its class
Part.cc
- Virtual base class of all Parts.
Part.h 
- header file with declarations of functions and member variables for its class
    FH_Part
    - A part that must be inspected after a certain number of flight hours.
    IT_Part
    - A part that must be inspected after a certain number of days of being installed on an aircraft.
    FHIT_Part
    - A part that must be inspected after a certain number of days of being installed on an aircraft and after a
    certain number of flight hours.
Array.cc
- A simple (templated) data structure.
Array.h 
- header file with declarations of functions and member variables for its class
Airline.cc
- Aircraft data as well as a container for the installed Parts.
Airline.h 
- header file with declarations of functions and member variables for its class
Airline.cc
- Tracks parts, aircraft, installations, flights, etc.
Airline.h 
- header file with declarations of functions and member variables for its class

running instructions*
- enter make command in terminal thats in the folder directory of this assignment
- enter ./a4 or valgrind ./a4
- input test commands