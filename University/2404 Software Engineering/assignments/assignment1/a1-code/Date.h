
#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <string>

using namespace std;

const int maxduration = 3;
class Date {
		
	public:
		//constructor
		Date();
		Date(int year, int month, int day, int hour, int duration);
		
				
		//setters
		void setDay( int);
		void setMonth(int);
		void setYear(int);
		void sethour(int);
		void setduration(int);
		void setDate(int, int, int,int,int);
		void setDate(Date&);
		
		//getters
		int getDay();
		int getMonth();
		int getYear();
		int getHour();
		int getDuration();
		const string& getMonthName();
		
		//other
		bool lessThan(Date& d);
		bool overlaps(Date& d);
		void print();
	
	private:
		//functions
		int getMaxDay();
	
	
		//variables
		int day;
		int month;
		int year;
		int hour;
		int duration;
		
		const string months[12] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		const string smonths[12]={"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug", "Sep", "Oct", "Nov", "Dec"};
	
};
#endif
