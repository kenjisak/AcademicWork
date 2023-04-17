#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <string>

using namespace std;

class Time{ 
    public: 
      Time(int = 0, int = 0, int = 0); 
      Time& operator+=(const int);
      Time  operator+(const int);
      bool operator==(Time&);
      bool operator==(int);
 
    private: 
      int seconds, minutes, hours; 
      int convertToSeconds(); 
      void  setTime(int);
 };
#endif