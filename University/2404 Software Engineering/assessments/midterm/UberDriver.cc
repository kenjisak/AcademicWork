#include "UberDriver.h"

UberDriver::UberDriver(){
    name = "Uber Driver Name";
    rating = 5.0;
    //uberdriverscar = new Car();
}
UberDriver::UberDriver(string name,float rating){
    this->name = name;
    this->rating = rating;
}
UberDriver::UberDriver(UberDriver& ud){//deep const
    name = ud.name;
    rating = ud.rating;
}
UberDriver::~UberDriver(){
    //delete uberdriverscar;
}