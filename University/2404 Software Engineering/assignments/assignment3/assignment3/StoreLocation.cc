#include <iostream>
#include <string>

using namespace std;

#include "StoreLocation.h"

int StoreLocation::nextId = 1;

StoreLocation::StoreLocation():Location(convert(code),nextId++){}

string StoreLocation::convert(char c){ 
    string returnthis;
    returnthis.push_back(c);
    return returnthis;
}
void StoreLocation::setProduct(string prod){
    product = prod;
}
int StoreLocation::getFreeSpace(){
    return capacity - quantity;
}
int StoreLocation::getCapacity(){
    return capacity;
}
int StoreLocation::getQuantity(){
    return quantity;
}
bool StoreLocation::add(string prodname, int quantity){
    if (isAvailable()){ // if store no product
        product = prodname;
        if (this->quantity + quantity <= capacity){
            this->quantity += quantity;
            cout<< "Product added to this store" <<endl;
            return true;
        }else{
            cout<< "Product will go over max capacity at this store" <<endl;
            return false;
        }
        
    }else{//if store has product
        if (getproduct() == prodname){
            if (this->quantity + quantity <= capacity){
                this->quantity += quantity;
                cout<< "Product added to this store" <<endl;
                return true;
            }else{
                cout<< "Product will go over max capacity at this store" <<endl;
                return false;
            }
        }
        cout<< "Product doesnt exist at this store" <<endl;
        return false;
    }
}
bool StoreLocation::remove(int amount){
    if (amount > quantity){
        cout<< "Product removal unsuccessful" <<endl;
        return false;
    }else{
        quantity -= amount;
        cout<< "Product removal successful" <<endl;
        return true;
    }
}

void StoreLocation::print(){
    cout<< "id of location: " << id <<endl;
    cout<< "product of location: " << product <<endl;
    cout<< "quantity of location: " << quantity <<endl;
}