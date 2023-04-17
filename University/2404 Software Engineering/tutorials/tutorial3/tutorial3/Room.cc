#include "Room.h"

//constructor
Room::Room(string name,int capacity, int computers,bool whiteboard){
    setRoom(name,capacity,computers,whiteboard);
}
Room::Room(Room& r){
    setRoom(r.name,r.capacity,r.computers,r.whiteboard);
}

//setters
void Room::setName(string n){
    name = n;
}

void Room::setCapacity(int c){
    capacity = c;
}

void Room::setComputers(int co){
    computers = co;
}

void Room::setWhiteboard(bool w){
    whiteboard = w;
}

void Room::setRoom(string n,int c, int co, bool w){
    name = n;
    capacity = c;
    computers = co;
    whiteboard = w;
}

void Room::setRoom(Room& r){
    r.name = "john doe";
    r.capacity = 10;
    r.computers = 10;
    r.whiteboard = true;
}

//getters

string Room::getName(){
    return name;
}

int Room::getCapacity(){
    return capacity;
}

int Room::getComputers(){
    return computers;
}

bool Room::hasWhiteboard(){
    return whiteboard;
}

//functions
bool Room::meetsCriteria(int c, int co, bool w){
//return true if parameters of room meets or exceeds parameters given
    /*
    if (w == false){
        if(capacity >= c && computers >= co){
            return true;
        }else{
            return false;
        }
    }else{
        if(capacity >= c && computers >= co){
            return true;
        }else{
            return false;
        } 
    }
    */
    if(capacity >= c && computers >= co){//if the capacity is bigger or == and computers is greater or == to then check if theres white boards.
        if (w == false){
            return true;
        }else if(whiteboard == true){
            return true;
        }else{
            return false;
        }
    }else{
        return false;
    }
    
}
bool Room::lessThan(Room& r){
    if (this->name.compare(r.name)<0){
        return true;
    }else{
        return false;
    }
}
void Room::print(){
    cout<<"\n>Room name: "<<name<<"\n>Capacity: " << capacity<< "\n>Computers: "<<computers<<"\n>Has whiteboard: "<< whiteboard<<"\n";
}
