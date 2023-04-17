#ifndef IT_PART_H
#define IT_PART_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "Part.h"

using namespace std;

class IT_Part: virtual public Part
{
    friend ostream& operator<<(ostream& out, IT_Part&);//not needed

    private: 
        int it_inspect;
    public:
        IT_Part(string name,int it_inspect);

        int getinspect();
        
        virtual bool inspection(Date inspectiondate);
};
#endif

