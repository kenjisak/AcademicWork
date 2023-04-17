#ifndef FH_PART_H
#define FH_PART_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "Part.h"

using namespace std;

class FH_Part: virtual public Part
{
    friend ostream& operator<<(ostream& out, FH_Part&);//not needed

    private: 
        int fh_inspect;
    public:
        FH_Part(string name,int fh_inspect);

        int getinspect();

        virtual bool inspection(Date inspectiondate);
};
#endif

