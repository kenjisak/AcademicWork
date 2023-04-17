
#ifndef LIBRARY_H
#define LIBRARY_H

#include <iostream>
#include <string>

#include "Student.h"
#include "Room.h"
#include "Date.h"
#include "Reservation.h"

using namespace std;

class Library {
		
	public:
		//constructor
		Library();
		~Library();
				
		
		//other
        bool addRoom(string name);
        bool addRoom(string name,int capacity);
        bool addRoom(string name,int capacity, int computers);
        bool addRoom(string name,int capacity, int computers,bool whiteboard);
        bool addStudent(const string& name, const string& number);
        bool getStudent(const string& name, Student** student);
        bool getRoom(const string& roomName, Room** room);
        bool isFree(const string& room, Date&);
        bool makeReservation(const string& student, const string& room, Date&);
		void printReservations();

        void printstudent();
	
	private:
		//variables
        Student* students[10];
        Room* rooms[10];
        Reservation* reservations[10];
        //Student** students;
        //Room** rooms;
        //Reservation** reservations;
        int stucount;
        int rocount;
        int rescount;
};
#endif