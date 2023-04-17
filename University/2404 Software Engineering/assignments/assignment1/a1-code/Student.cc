#include "Student.h"

Student::Student(){
    setStudent("john doe","012345678");
}
Student::Student(string n,string num){
    
}

void Student::setName(string n){
    name = n;
}
void Student::setNumber(string num){
    number = num;
}
void Student::setStudent(string n,string num){
    setName(n);
    setNumber(num);
}
void Student::setStudent(Student& s){
    setStudent(s.name,s.number);
}

string Student::getName(){
    return name;
}
string Student::getNumber(){
    return number;
}
bool Student::lessThan(Student& s){
    if (this->number.compare(s.number)<0){
        return true;
    }else{
        return false;
    }
}
void Student::print(){
    cout<<getName()<<getNumber()<<endl;
}