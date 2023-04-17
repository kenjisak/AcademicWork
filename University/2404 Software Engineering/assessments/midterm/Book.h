
#ifndef BOOK_H
#define BOOK_H

#include <iostream>
#include <string>

using namespace std;

class Book{
		
	public:
		//constructor
		Book(const string&,const string&);
	
	private:
		//variables
		string name;
		string content;
};
#endif
