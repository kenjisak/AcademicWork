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
/*
string Part::getpartname(){
    return name;
}
*/
void Part::addFlightHours(int flighthours){
    this->flighthours += flighthours;
}

void Part::install(Date& installdate){
    this->installationDate = installdate;
}

/*
ostream& operator<<(ostream& out, Part& p){
	return out << p.getpartname() <<endl;
}
*/
//////////////////////////////////////////////////////
FH_Part::FH_Part(string name,int inspect):Part(name), fh_inspect(inspect){}


int FH_Part::getinspect(){
    return fh_inspect;
}
bool FH_Part::inspection(Date inspectiondate){
    return flighthours >= fh_inspect;
}
/*
ostream& operator<<(ostream& out, FH_Part& fhp){
	return out << fhp.getpartname() << fhp.getinspect() <<endl;
}
*/
///////////////////////////////////////////////////////
IT_Part::IT_Part(string name,int inspect):Part(name), it_inspect(inspect){}


int IT_Part::getinspect(){
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
/*
ostream& operator<<(ostream& out, IT_Part& itp){
	return out << itp.getpartname() << itp.getinspect() <<endl;
}
*/
//////////////////////////////////////////////////////////////
FHIT_Part::FHIT_Part(string name,int fh_inspect, int it_inspect):Part(name),FH_Part(name,fh_inspect),IT_Part(name,it_inspect){}



bool FHIT_Part::inspection(Date inspectiondate){
    return FH_Part::inspection(inspectiondate) || IT_Part::inspection(inspectiondate);
}
/*
ostream& operator<<(ostream& out, FHIT_Part& fhitp){
	return out << fhitp.getpartname() << fhitp.getinspect() <<endl;
}
*/