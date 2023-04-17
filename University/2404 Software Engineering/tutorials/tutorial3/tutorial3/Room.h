
#ifndef ROOM_H
#define ROOM_H

#include <iostream>
#include <string>

using namespace std;

class Room {
	private:

		//variables
        string name;
		int capacity;
		int computers;
		bool whiteboard;
	
	public:
		//constructor
		Room(string name,int capacity, int computers,bool whiteboard);
		Room(Room&);
		
		//setters
        void setName(string);
		void setCapacity(int);
		void setComputers(int);
		void setWhiteboard(bool);
		void setRoom(string, int, int,bool);
		void setRoom(Room&);
		
		//getters
		string getName();
		int getCapacity();
		int getComputers();
        bool hasWhiteboard();

	    //functions
        bool meetsCriteria(int capacity, int computers, bool whiteboard);
        bool lessThan(Room& r);
        void print();
};
#endif