#include <iostream>
#include <iomanip>
#include <string>

#include "question7.h"
using namespace std;

Time::Time(int h, int m, int s)
{
  hours = h;
  minutes = m;
  seconds = s;
}
int Time::convertToSeconds() {
  return (hours*3600 + minutes*60 + seconds);
}
void Time::setTime(int s){
  hours   = s / 3600;
  minutes = (s % 3600) / 60;
  seconds = (s % 3600) % 60;
}

Time& Time::operator+=(const int s){
  int tmpSecs = convertToSeconds();
  
  tmpSecs += s;

  setTime(tmpSecs);

  return *this;
}

Time Time::operator+(const int s){
  Time tmp;

  tmp = *this;

  tmp += s;
  return tmp;
}

bool Time::operator==(Time& t){
  return ( (hours   == t.hours)   &&
           (minutes == t.minutes) &&
           (seconds == t.seconds) );
}
bool Time::operator==(int s){
  return ( convertToSeconds() == s );
}
