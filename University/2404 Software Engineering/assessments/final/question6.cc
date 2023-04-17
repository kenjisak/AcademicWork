#include <iostream>
#include <string>
using namespace std;

#include "question6.h"

Animal::Animal(string name){
    this->name = name;
}
Animal::~Animal(){
    
}

Human::Human(string name,int feets):Animal(name), feet(feets){}


Goat::Goat(string name,int feets):Animal(name), feet(feets){}


Centaur::Centaur(string name,int hufeet, int goatfeet):Animal(name),Human(name,hufeet),Goat(name,goatfeet){}


