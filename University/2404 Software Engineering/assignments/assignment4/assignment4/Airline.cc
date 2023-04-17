#include "Airline.h"

Airline::Airline(string name){
    this->name = name;
}
Airline::~Airline(){
    for (int i = 0; i < partsarray.getSize(); i++){
        delete partsarray[i];
    }

    for (int i = 0; i < aircraftarray.getSize(); i++){
        delete aircraftarray[i];
    }
}

Part* Airline::getparts(string name){
    FHIT_Part* nosuchpart = new FHIT_Part("none",0,0);
    for (int i = 0; i < partsarray.getSize(); i++){
        if(partsarray.operator[](i)->getpartname() == name){
            return partsarray.operator[](i);
        }
    }
    //return for if theres no Part name matching
    return nosuchpart;
}
Aircraft* Airline::getaircrafts(string reg){
    Aircraft* nosuchreg = new Aircraft("none","none");
    for (int i = 0; i < aircraftarray.getSize(); i++){
        if(aircraftarray.operator[](i)->getreg() == reg){
            return aircraftarray.operator[](i);
        }
    }
    
    //return for if theres no Aircraft name matching
    return nosuchreg;
}
void Airline::addAircraft(string type, string registration){
    Aircraft* newAircraft = new Aircraft(type,registration);
    aircraftarray.add(newAircraft);
}
void Airline::addPart(const string& part, int fh_inspect, int it_inspect){
    if (fh_inspect == 0){
        IT_Part* newPart = new IT_Part(part,it_inspect);
        partsarray.add(newPart);
    }else if(it_inspect == 0){
        FH_Part* newPart = new FH_Part(part,fh_inspect);
        partsarray.add(newPart);
    }else{
        FHIT_Part* newPart = new FHIT_Part(part,fh_inspect,it_inspect);
        partsarray.add(newPart);
    }
}
void Airline::takeFlight(string reg, int hours){
    if(getaircrafts(reg)->getreg() == "none"){
        cout<<"no such aircraft"<<endl;
    }else{
        getaircrafts(reg)->takeFlight(hours);
    }
}
void Airline::printAircraft(){
    for (int i = 0; i < aircraftarray.getSize(); i++)
    {
        cout<<*aircraftarray[i]<<endl;
    }
}
void Airline::printParts(){
    for (int i = 0; i < partsarray.getSize(); i++)
    {
        cout<<*partsarray[i]<<endl;
    }
}
void Airline::inspectionReport(string reg, Date& date){
   
    Aircraft* temp = getaircrafts(reg);
    Array<Part*> out;
    if(temp->getreg() == "none"){
        cout<<"no such aircraft"<<endl;
    }else{
        temp->inspectionReport(date,out);
        cout<<"The following parts from " << temp->getreg() << " require inspection:"<<endl;
        for (int i = 0; i < out.getSize(); i++){
            cout<<*out[i]<<endl;
        }
    }
}
bool Airline::install(string reg, string partname,Date& date){
    if(getaircrafts(reg)->getreg() == "none" || getparts(partname)->getpartname() == "none"){
        cout<<"no such aircraft or part"<<endl;
        return false;
    }else{
        getaircrafts(reg)->install(getparts(partname),date);
        return true;
    }
    return false;
}