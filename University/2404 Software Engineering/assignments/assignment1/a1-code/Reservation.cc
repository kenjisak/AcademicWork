#include "Reservation.h"
#include "Date.h"

Reservation::Reservation(Student* s, Room* r, Date& d){
    *student = *s;
    *room = *r;
    date = &d;
}
Reservation::~Reservation(){
    delete student;//clear students in room
    delete date;//clear dates reserved
}

Student* Reservation::getStudent(){
    return student;
}
Room* Reservation::getRoom(){
    return room;
}
Date* Reservation::getDate(){
    return date;
}

bool Reservation::lessThan(Reservation& res){
    return this->date->lessThan(*res.date);
}
bool Reservation::overlaps(string r, Date& d){
    if (room->getName() == r){//if room name is the same
        if (this->date->overlaps(d)){//if overlaps dates
            return true;
        }
    }
    return false;
}
void Reservation::print(){
	cout << ">Reservation requests: "<< getStudent()<<","<<getRoom()<<", "<<getDate()<<endl;
}