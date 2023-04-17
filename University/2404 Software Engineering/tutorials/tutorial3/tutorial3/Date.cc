
#include "Date.h"

Date::Date(){
	setDate(1,1,1901,22, 2);
}

Date::Date(int y, int m, int d, int h, int dur){
	setDate(y,m,d,h,dur);
}


//setters
void Date::setDay(int d){
	int max = getMaxDay();
	if (d>max) d=max;
	if (d<1) d=1;
	day = d;
}

void Date::setMonth(int m){
	if (m > 12) m = 12;
	if (m < 1) m = 1;
	month = m;
}

void Date::setYear(int y){
	if (y < 1901) y = 1901;
	year = y;
}

void Date::sethour(int h){
	if(h<0){//if less than 0 then add time to closest hour
		while(h<0){
			h++;
		}

	}else if(h >23){//if greater than 23 subtract to closest hour
		while(h>23){
			h--;
		}
	}
	hour = h;
}
void Date::setduration(int d){
	if(d<0){//if less than 0 then add to closest 
		while(d<0){
			d++;
		}

	}else if(d>3){//if greater than subtract to closest 
		while(d>3){
			d--;
		}
	}
	duration = d;
}
void Date::setDate(int y, int m, int d, int h, int dur){
	setMonth(m);
	setDay(d);
	setYear(y);
	sethour(h);
	setduration(dur);
}

void Date::setDate(Date& d){
	setDate(d.day, d.month, d.year,d.hour,d.duration);
}



//getters
int Date::getDay(){ return day; }
int Date::getMonth(){ return month; }
int Date::getYear(){ return year; }
int Date::getHour(){ return hour; }
int Date::getDuration(){ return duration; }
const string& Date::getMonthName(){return months[month-1];}


//other

bool Date::lessThan(Date& d){
	if (year == d.year){
		if (month == d.month){
			if (hour == d.hour){
				return hour < d.hour;
			}else{
				return day < d.day;
			}
			
		}else{
			return month  < d.month;
		}
	}else{
		return year < d.year;
	}	
}

void Date::print(){
	cout << getMonthName()<<" "<<getDay()<<", "<<getYear()<<", "<<getHour()<<", "<<getDuration()<<endl;
}

int Date::getMaxDay(){
	switch(getMonth()){
		case 4:
		case 6:
		case 9:
		case 11: 			return 30;
		case 2:				return 28;
		default:			return 31;
	}
}
bool Date::overlaps(Date& d){
	int durcheck;
	if (year == d.year){
		if (month == d.month){
			if (day == d.day){
				if (hour == d.hour){// if same hour then overlap
				return true;
				}
				if(hour < d.hour){//if hour is earlier
					durcheck = d.hour - hour;
					if (duration <= durcheck){
						return false;
					}else{
						return true;
					}
				}
				if(hour > d.hour){//if d.hour is earlier
					durcheck = hour - d.hour;
					if (d.duration <= durcheck){//if d.hour duration is lesser or equal to duration check then doesnt overlap
						return false;
					}else{
						return true;
					}
				}
			}
		}
	}
	return false;
}

