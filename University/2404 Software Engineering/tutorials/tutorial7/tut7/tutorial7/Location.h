#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

using namespace std;

class Location{
    
    protected:
		//variables
        string id;
        string product;
        int quantity;
        const string NONE = "Empty";
        
	public:
        //getters
        string getId();
        string getProduct();
        int getQuantity();

		//constructor
        Location(string charc, int numc);		
        
        //functions
        void print();
        bool isEmpty();
        bool isAvailable();

        //virtual functions
        virtual int getCapacity() = 0;
        virtual bool add(string prod, int quan) = 0;
        virtual bool remove(int amount) = 0;
        
};
#endif