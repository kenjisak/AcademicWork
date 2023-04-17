#ifndef FHIT_PART_H
#define FHIT_PART_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "FH_Part.h"
#include "IT_Part.h"

using namespace std;

class FHIT_Part: virtual public Part, public FH_Part, public IT_Part
{
    friend ostream& operator<<(ostream& out, FHIT_Part&);//not needed

    public:
        FHIT_Part(string name,int fh_inspect, int it_inspect);

        virtual bool inspection(Date inspectiondate);
};
#endif

