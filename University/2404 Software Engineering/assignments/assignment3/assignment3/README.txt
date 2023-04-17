Kenji Isak Laguan
101160737

defs.h
- header file with declarations of member variables used for multiple classes
main.cc 
- launches test control to start testing this assignment
Location.cc
- A virtual base class for StoreLocation and WHLocation classes
Location.h
- header file with declarations of functions and member variables for its class
StoreLocation.cc 
- Concrete implementation for in-store product locations
StoreLocation.h 
- header file with declarations of functions and member variables for its class
WHLocation.cc 
- Concrete implementation for warehouse product locations.
WHLocation.h 
- header file with declarations of functions and member variables for its class
Product.cc 
- Contains information about the product, including the StoreLocation and WHLocations it is stored in.
Product.h 
- header file with declarations of functions and member variables for its class
List.cc
- A list of Products that can grow arbitrarily large
List.h 
- header file with declarations of functions and member variables for its class
Queue.cc 
- A first-in-first-out (FIFO) data structure for storing WHLocations. The FIFO nature of the data structure
ensures that we use older stock first
Queue.h 
- header file with declarations of functions and member variables for its class
Store.cc 
- Provides an interface for interacting with the inventory system.
Store.h 
- header file with declarations of functions and member variables for its class
Control.cc 
- Controls the interaction between the inventory system (Store) and the user.
Control.h 
- header file with declarations of functions and member variables for its class
View.cc 
- Collects user input and provides system output
View.h 
- header file with declarations of functions and member variables for its class
Makefile
- compiles all these files together into one executable to run

running instructions*
- enter make command in terminal thats in the folder directory of this assignment
- enter ./a3 or valgrind ./a3
- input test commands
- works fine if enter 2 test first then a large quantity
- then you can do test 1
- other wise any quantity with test 1 first will seg fault