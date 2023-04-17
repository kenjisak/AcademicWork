#ifndef SUBSCIRBER_H
#define SUBSCIRBER_H

#include <iostream>
#include <string>

using namespace std;

class Subscriber{
    private:
		//variables
        string name;
		string creditcard;
      
	public:
		//constructor
		Subscriber(string name,string creditcard);
			
	    //functions
        void print();
		string getName();
        bool matches(const string& name);
};

#endif