#include <iostream>
#include <string>

using namespace std;

#include "Location.h"

Location::Location(string charc, int numc){
    id = charc + to_string(numc);
    product = NONE;
    quantity = 0;
}
string Location::getId(){
    return id;
}
string Location::getProduct(){
    return product;
}
int Location::getQuantity(){
    return quantity;
}
bool Location::isEmpty(){
    if(this->quantity == 0){
        return true;
    }
    else{
        return false;
    }
}
bool Location::isAvailable(){
    if(this->product == NONE){
        return true;
    }
    else{
        return false;
    }
}
void Location::print(){
    //cout<< "Id = "<< id<< "Product = "<< product<< "Quantity = "<< quantity<< endl;
    cout<< "id of location: " << id <<endl;
    cout<< "product of location: " << product <<endl;
    cout<< "quantity of location: " << quantity <<endl;
}