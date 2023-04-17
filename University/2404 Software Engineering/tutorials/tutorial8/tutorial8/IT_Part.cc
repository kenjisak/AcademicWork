#include <iostream>
#include <string>

using namespace std;

#include "IT_Part.h"

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