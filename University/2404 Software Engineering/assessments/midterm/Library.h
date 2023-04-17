
#ifndef LIBRARY_H
#define LIBRARY_H

#include <iostream>
#include <string>
#include "Book.h"
using namespace std;

#define MAX 200
class Library{
		
	public:
		//constructor
		Library(const string& name);
        Library(const Library&);
        ~Library();

        void addBook(const string& name, const string& content){
            if (numBooks >= MAX) return;
            books[numBooks++] = new Book(name,content);
        }
	private:
		//variables
		string name;
		Book** books;
        int numBooks;
};
#endif
