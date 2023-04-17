#include <iostream>
#include <string>

using namespace std;

#include "StoreLocation.h"


int StoreLocation::nextId = 1;

StoreLocation::StoreLocation(): Location(convert(code), nextId++){}

string StoreLocation::convert(char c){ 
    string returnthis;
    returnthis.push_back(c);
    return returnthis;
}
void StoreLocation::setProduct(string prod){
    product = prod;
}
int StoreLocation::getFreeSpace(){
    int temp = 0;
    temp = capacity - quantity;
    return temp;
}
void StoreLocation::print(){
    cout<< "Store Id = "<< id<< "Product = "<< product<< "Quantity = "<< quantity<< endl;
}
int StoreLocation::getCapacity(){
    return capacity;
}
bool StoreLocation::add(string prod, int quan){
    if(product == NONE){
        product = prod;
        if((quantity + quan) <= capacity){
            quantity += quan;
            return true;
        }
        else{
            return false;
        }
        return true;
    }
    else if(product == prod){
        if((quantity + quan) <= capacity){
            quantity += quan;
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}
bool StoreLocation::remove(int amount){
    if(amount > quantity){
        return false;
    }
    else{
        quantity = quantity - amount;
        return true;
    }
}