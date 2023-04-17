#include <iostream>
#include <string>
using namespace std;

#include "Part.h"

Part::Part(string name){
    this->name = name;
    this->flighthours = 0;
}
Part::~Part(){
    
}

string Part::getpartname(){
    return name;
}

void Part::addFlightHours(int flighthours){
    this->flighthours += flighthours;
}

void Part::install(Date& installdate){
    this->installationDate = installdate;
}

//////////////////////////////////////////////////////
FH_Part::FH_Part(string name,int inspect):Part(name), fh_inspect(inspect){}


int FH_Part::getfhinspect(){
    return fh_inspect;
}
bool FH_Part::inspection(Date inspectiondate){
    return flighthours >= fh_inspect;
}
///////////////////////////////////////////////////////
IT_Part::IT_Part(string name,int inspect):Part(name), it_inspect(inspect){}


int IT_Part::getitinspect(){
    return it_inspect;
}
bool IT_Part::inspection(Date inspectiondate){
    if (installationDate.toDays() > inspectiondate.toDays()){
        return (installationDate.toDays() - inspectiondate.toDays()) >= it_inspect;
    }else if(installationDate.toDays() > inspectiondate.toDays()){
        return (inspectiondate.toDays() - installationDate.toDays()) >= it_inspect;
    }else{//equal = 0
        return (inspectiondate.toDays() - installationDate.toDays()) >= it_inspect;
    }
}
//////////////////////////////////////////////////////////////
FHIT_Part::FHIT_Part(string name,int fh_inspect, int it_inspect):Part(name),FH_Part(name,fh_inspect),IT_Part(name,it_inspect){}

bool FHIT_Part::inspection(Date inspectiondate){
    return FH_Part::inspection(inspectiondate) || IT_Part::inspection(inspectiondate);
}
//////////////////////////////////////////////////////////////
ostream& operator<<(ostream& out, Part& p){
    p.print(out);
    return out;
}
