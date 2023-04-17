#ifndef STORELOCATION_H
#define STORELOCATION_H

#include <iostream>
#include <string>
#include "Location.h"
#include "defs.h"

using namespace std;

class StoreLocation: public Location{
    
    private:
		//variables
        static const char code = 'A';
        static const int capacity = SLOC_CAPACITY;
        static int nextId;
	public:
		//constructor
        StoreLocation();		
        
        //functions
        void setProduct(string);
        int getFreeSpace();
        void print();
        string convert(char c);
        //virtual functions
        virtual int getCapacity();
        virtual bool add(string, int);
        virtual bool remove(int amount);
        
};
#endif