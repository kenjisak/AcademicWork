#ifndef AIRLINE_H
#define AIRLINE_H

#include <iostream>
#include <string>
#include <iomanip>
#include "Aircraft.h"
#include "Array.h"

using namespace std;

class Airline{
	private:
        string name;
        Array<Part*> partsarray;
        Array<Aircraft*> aircraftarray;

        Part* getparts(string name);
        Aircraft* getaircrafts(string registration);

	public:
        Airline(string name);
        ~Airline();

        void addAircraft(string type, string registration);
        void addPart(const string& part, int fh_inspect, int it_inspect);
        void takeFlight(string reg, int hours);
        void printAircraft();
        void printParts();
        void inspectionReport(string reg, Date&);
        bool install(string airreg, string partname,Date&); 
};
#endif