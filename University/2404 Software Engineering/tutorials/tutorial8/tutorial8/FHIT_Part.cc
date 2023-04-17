#include <iostream>
#include <string>

using namespace std;

#include "FHIT_Part.h"

FHIT_Part::FHIT_Part(string name,int fh_inspect, int it_inspect):Part(name),FH_Part(name,fh_inspect),IT_Part(name,it_inspect){}



bool FHIT_Part::inspection(Date inspectiondate){
    return FH_Part::inspection(inspectiondate) || IT_Part::inspection(inspectiondate);
}
/*
ostream& operator<<(ostream& out, FHIT_Part& fhitp){
	return out << fhitp.getpartname() << fhitp.getinspect() <<endl;
}
*/