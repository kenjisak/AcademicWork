#include "Aircraft.h"

Aircraft::Aircraft(string type,string reg){
    this->type = type;
    this->registration = reg;
}
 
string Aircraft::getreg(){
    return registration;
}
void Aircraft::install(Part* partptr ,Date& date){
    partsarray.add(partptr);
    partptr->install(date);
}
void Aircraft::takeFlight(int hours){
    flighthours += hours;
    for (int i = 0; i < partsarray.getSize(); i++){
        partsarray.operator[](i)->addFlightHours(hours);
    }
}
void Aircraft::inspectionReport(Date& date,Array<Part*>& out){
    for (int i = 0; i < partsarray.getSize(); i++){
        if(partsarray.operator[](i)->inspection(date)){
            out.add(partsarray.operator[](i));
        }
    }
}
ostream& operator<<(ostream& out, Aircraft& a){
    out << "Aircraft:      " << a.type <<endl;
    out << "Registration:  " << a.registration <<endl;
	return out;
}