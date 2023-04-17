#include <istream>
#include <string>

#include "defs.h"
#include "Date.h"
#include "Part.h"


using namespace std;



int testFH_Part(Part*, const string&);
int testIT_Part(Part*, const string&);
int testFHIT_Part(Part*);

int main(){

  
    int choice = 0;
    cin >> choice;
    int ret = 0;
    Part* part;
    switch(choice){
      case 0: part = new FH_Part("Part1", 100);
              cout<<"FH_Part with fh_inpect = 100 being installed"<<endl;
              ret = testFH_Part(part, "FH_Part"); break;
      case 1: part = new IT_Part("Part1", 100);
              cout<<"IT_Part with it_inpect = 100 days being installed"<<endl;
              ret = testIT_Part(part, "IT_Part"); break;
      case 2: part = new FHIT_Part("Part1", 100, 400);
              cout<<"FHIT_Part with fh_inpect = 100  hours and it_inspect = 400 days being installed"<<endl;
              ret = testFH_Part(part, "FHIT_Part"); break;
      case 3: part = new FHIT_Part("Part1", 100, 200);
              cout<<"FHIT_Part with fh_inpect = 100  hours and it_inspect = 200 days being installed"<<endl;
              ret = testIT_Part(part, "FHIT_Part"); break;
      case 4: part = new FHIT_Part("Part1", 100, 200);
              ret = testFHIT_Part(part); break;
    }
    delete part;
    return ret;
  
}

int testFH_Part(Part* part, const string& type){
    Date d1(2021,9,17);
    Date d2(2022,9,17);
    part->install(d1);
    if (part->inspection(d2)){
      cout<<"Error: "<<type<<" with 0 hours inspection returned true (should be false)"<<endl;
      return 1;
    }

    part->addFlightHours(50);
    if (part->inspection(d2)){
      cout<<"Error: "<<type<<" with 50 hours inspection returned true (should be false)"<<endl;
      return 1;
    }

    part->addFlightHours(100);
    if (!part->inspection(d2)){
      cout<<"Error: "<<type<<" with 150 hours inspection returned false (should be true)"<<endl;
      return 1;
    }
    cout<<"All tests passed"<<endl;
    return 0;
    
}

int testIT_Part(Part* part, const string& type){
    Date d1(2021,9,17);
    Date d2(2021,10,17);
    Date d3(2022, 10, 17);
    part->install(d1);
    if (part->inspection(d1)){
      cout<<"Error: "<<type<<" with 0 days installed inspection returned true (should be false)"<<endl;
      return 1;
    }

    if (part->inspection(d2)){
      cout<<"Error: "<<type<<" with 30 days installed inspection returned true (should be false)"<<endl;
      return 1;
    }

    if (!part->inspection(d3)){
      cout<<"Error: "<<type<<" with 365 days installed inspection returned false (should be true)"<<endl;
      return 1;
    }
    cout<<"All tests passed"<<endl;
    return 0;

}

int testFHIT_Part(Part* part){
    Date d1(2021,9,17);
    Date d2(2021,10,17);
    Date d3(2022,9,17);
    cout<<"FHIT_Part with fh_inspect = 100 hours and it_inspect = 200 days being installed"<<endl;
    part->install(d1);
    if (part->inspection(d1)){
      cout<<"Error: FHIT_Part with 0 flight hours and 0 installed days inspection returned true (should be false)"<<endl;
      return 1;
    }

    part->addFlightHours(50);
    if (part->inspection(d2)){
      cout<<"Error: FHIT_Part with 50 hours and 30 days inspection returned true (should be false)"<<endl;
      return 1;
    }

    part->addFlightHours(100);
    if (!part->inspection(d3)){
      cout<<"Error: FHIT_Part with 150 hours and 365 days inspection returned false (should be true)"<<endl;
      return 1;
    }
    cout<<"All tests passed"<<endl;
    return 0;

}

