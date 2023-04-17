#ifndef PART_H
#define PART_H

#include <iostream>
#include <string>
#include <iomanip>

#include "defs.h"
#include "Date.h"
using namespace std;

class Part
{
    //friend ostream& operator<<(ostream& out, Part&);//not needed

    protected:
        string name;
        Date installationDate;
        int flighthours;
    public:
        Part(string name);
        

        //string getpartname();
    
        virtual bool inspection(Date inspectiondate)=0;
        virtual ~Part();
        
        void addFlightHours(int);
        void install(Date&);
};

class FH_Part: virtual public Part
{
    //friend ostream& operator<<(ostream& out, FH_Part&);//not needed

    private: 
        int fh_inspect;
    public:
        FH_Part(string name,int fh_inspect);

        int getinspect();

        virtual bool inspection(Date inspectiondate);
};

class IT_Part: virtual public Part
{
    //friend ostream& operator<<(ostream& out, IT_Part&);//not needed

    private: 
        int it_inspect;
    public:
        IT_Part(string name,int it_inspect);

        int getinspect();
        
        virtual bool inspection(Date inspectiondate);
};

class FHIT_Part: virtual public Part, public FH_Part, public IT_Part
{
    //friend ostream& operator<<(ostream& out, FHIT_Part&);//not needed

    public:
        FHIT_Part(string name,int fh_inspect, int it_inspect);

        virtual bool inspection(Date inspectiondate);
};
#endif

