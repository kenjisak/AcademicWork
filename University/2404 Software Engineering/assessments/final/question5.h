#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <string>

using namespace std;

class Date {     
    public: 
        Date(int = 1901, int = 1, int = 1); 
        Date(Date&); 
         
        //setters 
        Date &setDay(int); 
        Date &setMonth(int); 
        Date &setYear(int); 
        Date &setDate(int, int, int); 
        Date &setDate(Date&); 
             
    private: 
         
        int day; 
        int month; 
        int year; 
};
#endif