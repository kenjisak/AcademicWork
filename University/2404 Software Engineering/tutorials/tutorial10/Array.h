
#ifndef ARRAY_H
#define ARRAY_H

#include <iostream>
#include <string>
#include <iomanip>
#include <cstdlib>
#include "defs.h"

using namespace std;


class Array {

	public:
		//constructor
		Array();
				
		//destructor
		~Array();
		
		//other
		void add(int);
		int get(int index);
		int getSize();
		bool isFull();
	
	private:
		int size;
		int* elements;
	
};

Array::Array(){
	elements = new int[MAX_ARR];
	size = 0;
}

Array::~Array(){
	delete [] elements;
}

void Array::add(int t){
	if (size >= MAX_ARR)   return;
  	elements[size++] = t;
}

int Array::getSize(){
	return size;
}

bool Array::isFull(){
	return size >= MAX_ARR;
}

int Array::get(int index){
	if (index < 0 || index >= size) {
		cerr<<"Array index out of bounds"<<endl;
		exit(1);
	}
	return elements[index];
}

#endif