#include <iostream>
#include <string>

using namespace std;

#include "WHLocation.h"

int WHLocation::nextId = 1;

WHLocation::WHLocation():Location(convert(code),nextId++){}

string WHLocation::convert(char c){ 
    string returnthis;
    returnthis.push_back(c);
    return returnthis;
}

int WHLocation::getCapacity(){
    return capacity;
}
int WHLocation::getQuantity(){
    return quantity;
}
bool WHLocation::add(string prodname, int quantity){
    if (isAvailable() && this->quantity + quantity <= capacity){ // if warehouse is avail/no productand fits
        product = prodname;
        this->quantity = quantity;
        cout<< "Product added to this store" <<endl;
        return true;
    }else{//if warehouse has product
        cout<< "addition of product not allowed" <<endl;
        return false;
    }
}
bool WHLocation::remove(int amount){
    if ((quantity - amount) == 0){
        product = NONE;
        quantity -= amount;
        cout<< "Product removal successful. warehouse empty" <<endl;
        return true;
    }

    if (amount > quantity){//more products to remove than quantity
        cout<< "Product removal unsuccessful" <<endl;
        return false;
    }else if (amount <= quantity){//less products thatn quantity
        quantity -= amount;
        cout<< "Product removal successful" <<endl;
        return true;
    }
    return false;
}

void WHLocation::print(){
    cout<< "id of warehouse location: " << id <<endl;
    cout<< "product of warehouse location: " << product <<endl;
    cout<< "quantity of warehouse location: " << quantity <<endl;
}