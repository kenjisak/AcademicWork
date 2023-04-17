#include <iostream>
#include <string>
using namespace std;

#include "Location.h"

Location::Location(string charcode,int numcode){
    this->id = charcode;
    id += to_string(numcode);
    product = NONE;
    quantity = 0;
}
string Location::getid(){
    return id;
}
string Location::getproduct(){
    return product;
}
int Location::getquantity(){
    return quantity;
}
bool Location::isEmpty(){
    return quantity == 0;
}
bool Location::isAvailable(){
    return product == NONE;
}
void Location::print(){
    cout<< "id of location: " << id <<endl;
    cout<< "product of location: " << product <<endl;
    cout<< "quantity of location: " << quantity <<endl;
}
