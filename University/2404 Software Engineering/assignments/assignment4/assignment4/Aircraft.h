#ifndef AIRCRAFT_H
#define AIRCRAFT_H

#include <iostream>
#include <string>
#include <iomanip>
#include "Part.h"
#include "defs.h"
#include "Array.h"

using namespace std;

class Aircraft {

    friend ostream& operator<<(ostream& out, Aircraft&);
	private:
        string type;
        string registration;
        int flighthours;
        Array<Part*> partsarray;

	public:
        Aircraft(string type,string registration);

        string getreg();

        void install(Part*,Date&);
        void takeFlight(int hours);
        void inspectionReport(Date&,Array<Part*>&);
};
#endif