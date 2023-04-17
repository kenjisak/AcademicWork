#ifndef STORELOCATION_H
#define STORELOCATION_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "Location.h"

using namespace std;

class StoreLocation: public Location
{
    private:
        static const char   code = 'A';
        static const int    capacity = SLOC_CAPACITY;
        static int nextId;

    public:
        StoreLocation();

        void    setProduct(string prod);
        int     getFreeSpace();
        void    print();
        string  convert(char c);

        virtual int getQuantity();
        virtual int getCapacity();
        virtual bool add(string prodname, int quantity);
        virtual bool remove(int amount);
};
#endif

