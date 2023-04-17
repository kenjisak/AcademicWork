#include <iostream>
#include <string>

using namespace std;

#include "FH_Part.h"

FH_Part::FH_Part(string name,int inspect):Part(name), fh_inspect(inspect){}


int FH_Part::getinspect(){
    return fh_inspect;
}
bool FH_Part::inspection(Date inspectiondate){
    return flighthours >= fh_inspect;
}

ostream& operator<<(ostream& out, FH_Part& fhp){
	return out << fhp.getpartname() << fhp.getinspect() <<endl;
}