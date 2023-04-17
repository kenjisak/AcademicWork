#ifndef WHLOCATION_H
#define WHLOCATION_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "Location.h"

using namespace std;

class WHLocation: public Location
{
    private:
        static const char   code = 'B';
        static const int    capacity = WHLOC_CAPACITY;
        static int nextId;

    public:
        WHLocation();
        
        void    print();
        string  convert(char c);
        
        virtual int getQuantity();
        virtual int getCapacity();
        virtual bool add(string prodname, int quantity);
        virtual bool remove(int amount);
};
#endif
