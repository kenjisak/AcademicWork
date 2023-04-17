
#ifndef UBERDRIVER_H
#define UBERDRIVER_H

#include <iostream>
#include <string>
//#include "Car.h"
using namespace std;

class UberDriver{
		
	public:
		//constructor
		UberDriver();
		UberDriver(string name,float rating);
        UberDriver(UberDriver&);
        ~UberDriver();
	
	private:
		//variables
		string name;
		float rating;
		//Car uberdriverscar;
};
#endif
