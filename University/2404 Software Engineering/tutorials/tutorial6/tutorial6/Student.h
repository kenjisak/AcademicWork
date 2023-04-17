
#ifndef STUDENT_H
#define STUDENT_H

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class Student {
		
	public:
		//constructor
		Student(const string& name, const string& number);
		//copy constructor
		Student(Student&);
		
		//destructor
		~Student();

		//getters
		string getName();
		string getNumber();
		
		//other
		bool lessThan(Student&);
		void print();
	
	private:
		string name;
		string number;
	
};
#endif
