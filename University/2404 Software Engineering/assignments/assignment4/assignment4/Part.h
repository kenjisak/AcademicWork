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
    friend ostream& operator<<(ostream&, Part&);

    protected:
        string name;
        Date installationDate;
        int flighthours;
    public:
        Part(string name);
    
        string getpartname();
    
        virtual bool inspection(Date inspectiondate)=0;
        virtual ~Part();
        virtual void print(ostream& os){
            os << "Part:              " << name <<endl;
            os << "Flight hours:      " << flighthours <<endl;
            os << "Installation Date: " << installationDate;
        }
        
        void addFlightHours(int);
        void install(Date&);
};

class FH_Part: virtual public Part
{
    private: 
        int fh_inspect;
    public:
        FH_Part(string name,int fh_inspect);

        int getfhinspect();

        virtual bool inspection(Date inspectiondate);
        virtual void print(ostream& os){
            os << "Part:              " << name <<endl;
            os << "Flight hours:      " << flighthours <<endl;
            os << "Installation Date: " << installationDate;
            os << "Inspect every:     " << fh_inspect << " flight hours"<<endl;
        }
};

class IT_Part: virtual public Part
{
    private: 
        int it_inspect;
    public:
        IT_Part(string name,int it_inspect);

        int getitinspect();

        virtual bool inspection(Date inspectiondate);
        virtual void print(ostream& os){
            os << "Part:              " << name <<endl;
            os << "Flight hours:      " << flighthours <<endl;
            os << "Installation Date: " << installationDate;
            os << "Inspect every:     " << it_inspect << " days installed"<<endl;
        }
};

class FHIT_Part: virtual public Part, public FH_Part, public IT_Part
{
    public:
        FHIT_Part(string name,int fh_inspect, int it_inspect);

        virtual bool inspection(Date inspectiondate);
        virtual void print(ostream& os){
            os << "Part:              " << name <<endl;
            os << "Flight hours:      " << flighthours <<endl;
            os << "Installation Date: " << installationDate;
            os << "Inspect every:     " << getfhinspect() << " flight hours"<<endl;
            os << "Inspect every:     " << getitinspect() << " days installed"<<endl;
        }
};
#endif

