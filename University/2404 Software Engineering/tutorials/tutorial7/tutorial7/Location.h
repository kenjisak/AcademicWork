#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"

using namespace std;

class Location
{
    protected:
        string const NONE = "Empty";
        string id;
        string product;
        int quantity;
    public:
        Location(string charcode,int numcode);

        string getid();
        string getproduct();
        int getquantity();

        virtual int getCapacity()=0;
        virtual bool add(string prodname, int quantity)=0;
        virtual bool remove(int quantity)=0;

        bool isEmpty();
        bool isAvailable();
        void print();
};
#endif

