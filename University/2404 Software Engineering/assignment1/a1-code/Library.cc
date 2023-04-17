#include "Library.h"

Library::Library(){
    stucount = 0;
    rocount = 0;
    rescount = 0;
    
    for (int i = 0; i < 10; i++){
        students[i] = NULL;
    }
    for (int i = 0; i < 10; i++){
        rooms[i] = NULL;
    }
    for (int i = 0; i < 10; i++){
        reservations[i] = NULL;
    }
}

Library::~Library(){
    //delete [] students;
    //delete [] rooms;
    //delete [] reservations;
    stucount = 0;
    rocount = 0;
    rescount = 0;
}
bool Library::addStudent(const string& name, const string& number){
    
    if (stucount < 10){//not full
        students[stucount] = new Student(name,number);
        stucount++;
        return true;
    }else{
        return false;
    }
}
void Library::printstudent(){
    for (int i = 0; i < 5; i++)
    {
        cout<< students[i]->getName();
    }
    
    
}
bool Library::addRoom(string name){//1,0,false
    if (stucount < 10){//not full
        rooms[rocount] = new Room(name,1,0,false);//63
        rocount++;//64
        return true;
    }else{
        return false;
    }
}
bool Library::addRoom(string name,int capacity){
    if (stucount < 10){//not full
        rooms[rocount] = new Room(name,capacity,0,false);//63
        rocount++;//64
        return true;
    }else{
        return false;
    }
}
bool Library::addRoom(string name,int capacity, int computers){
    if (stucount < 10){//not full
        rooms[rocount] = new Room(name,capacity,computers,false);//63
        rocount++;//64
        return true;
    }else{
        return false;
    }
}
bool Library::addRoom(string name,int capacity, int computers,bool whiteboard){
    if (stucount < 10){//not full
        rooms[rocount] = new Room(name,capacity,computers,whiteboard);//63
        rocount++;//64
        return true;
    }else{
        return false;
    }
}

bool Library::getStudent(const string& name, Student** student){
    //iterate through array and find the student that matches the name// then set that student to the dp passed
    for (int i = 0; i < stucount; i++){
        if (students[i]->getName() == name){
            *student = students[i];
            return true;
        }
    }
    return false;
}
bool Library::getRoom(const string& roomName, Room** room){
    for (size_t i = 0; i < rocount; i++){
        if (rooms[i]->getName() == roomName){
            *room = rooms[i];
            return true;
        }
    }
    return false;
}
bool Library::isFree(const string& room, Date& d){
    for (int i = 0; i < rocount; i++){
        if (rooms[i]->getName() == room){//found room
            //check overlap
            for (int x = 0; x < rescount; x++){
                if (reservations[x]->overlaps(room,d)==false){//if overlap false == room free
                    return true;
                }else{//if overlap== true room isnt free
                    return false;
                }
            }
        }
    }
    //didnt find room 
    return false;
}
bool Library::makeReservation(const string& student, const string& room, Date& d){
    //if room or student doesnt exist return false
        //if they exist check if room is free on passed date
            //make new reservation object and add to reservation array
        //else if not free or reservation array is full, return false , no changes
    Student* studentpass;
    Room* roompass;
    if(!getStudent(student,&studentpass) ||  !getRoom(room,&roompass)){//if doenst exsist either
        return false;
    }else{
        if(isFree(room,d)){//if room is free on date
            //if res array isnt full
            if (rescount < 64){//not full
                reservations[rescount] = new Reservation(studentpass,roompass,d);//63
                rescount++;//64
                return true;
            }
        }
        return false;
    }
}
void Library::printReservations(){
    for (int x = 0; x < rescount; x++){
        cout<<">Reservations for " << reservations[x]->getRoom()<< " room: \n" <<reservations[x]->getDate()<<endl;
    }
}