
#include "Student.h"

Student::Student(const string& name, const string& number):name(name),number(number){ }

Student::Student(Student& student){
	name = student.name;
	number = student.number;
}


Student::~Student(){
}

string Student::getName(){
	return name;
}

string Student::getNumber(){
	return number;
}

bool Student::lessThan(Student& s){
	return number < s.number;
}

void Student::print(){
	cout<<endl;
	cout << "Student name:   "<<name<<endl;
	cout << "Student Number: "<<number<<endl<<endl;
}
