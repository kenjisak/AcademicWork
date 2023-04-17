
#include "Store.h"


Store::Store(const string& name){
    this->name = name;
    products = new List();
}
Store::~Store(){
    delete products;
}
void Store::findAvailableSLoc(StoreLocation** sloc){
    for (int i = 0 ; i < SLOCS; i++){
        if (storelocations[i].isAvailable()){
            *sloc = &storelocations[i];
        }
    }
}
void Store::findAvailableWHLoc(WHLocation** wloc){
    for (int i = 0 ; i < SLOCS; i++){
        if (whlocations[i].isAvailable()){
            *wloc = &whlocations[i];
        }
    }
}
void Store::findProduct(const string& name, Product** prod){
    products->findProduct(name,prod);
}
void Store::printStoreStock(){
    for (int i = 0 ; i < SLOCS; i++){
        if (!storelocations[i].isAvailable()){
            storelocations[i].print();
        }
    }
}
void Store::printWareHouseStock(){
    for (int i = 0 ; i < SLOCS; i++){
        if (!whlocations[i].isAvailable()){
            whlocations[i].print();
        }
    }
}
void Store::printProducts(){
    products->print();
}

////////////////////////////////////////////////////////////////////
void Store::receiveProduct(const string& pname, int quantity){
    Product* prod = NULL;
    cout<<"Receiving..."<<endl;
    products->findProduct(pname, &prod);
    if (prod==NULL){
        cout<<"Making new product"<<endl;
        StoreLocation* sloc;
        findAvailableSLoc(&sloc);
        prod = new Product(pname, sloc);
        products->add(prod);
        
    }


    WHLocation* bloc;
    while(quantity > 0){
        findAvailableWHLoc(&bloc);
        if (quantity > bloc->getCapacity()){
            bloc->add(pname, bloc->getCapacity());
            prod->addWHLocation(bloc);
            quantity -= bloc->getCapacity();
        }else{
            bloc->add(pname, quantity);
            prod->addWHLocation(bloc);
            quantity = 0;
        }
    }

    cout<<"stocking store location..."<<endl;
    prod->stockStoreLocation();

}

void Store::fillOrder(const string& product, int& quantity){
    Product* prod;
    findProduct(product, &prod);
    if (prod == NULL){
        return;
    }
    prod->fillOrder(quantity);
}


void Store::print(){
    cout<<"Store: "<<name<<endl;
}