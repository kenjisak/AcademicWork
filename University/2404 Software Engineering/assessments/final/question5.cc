#include <iostream>
#include <string>
#include <cstdlib>

#include "question5.h"
using namespace std;

Date::Date(int y, int m, int d){
	setDate(y,m,d);
}
Date::Date(Date& d){
	setDate(d);
}
Date &Date::setDay(int d){
    day = d;
}
Date &Date::setMonth(int m){
    month = m;
}
Date &Date::setYear(int y){
    year = y;
}
Date &Date::setDate(int y, int m, int d){
    year = y;
    month = m;
    day = d;
}
Date &Date::setDate(Date& d){
    year = d.year;
    month = d.month;
    day = d.day;
}