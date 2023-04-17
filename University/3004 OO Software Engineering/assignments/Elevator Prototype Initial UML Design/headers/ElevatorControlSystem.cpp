#include "ElevatorControlSystem.h"

ElevatorControlSystem::ElevatorControlSystem(const int& elevnum,const int& flrnum,const int& maxweight){
    Floor* floorsarr[flrnum];

    for (int i = 0;i < flrnum;i++){
        floorsarr[i] = new Floor(i+1);
    }
    floors = floorsarr;

    Elevator* elevarr[elevnum];

    for (int i = 0;i < elevnum;i++){
        elevarr[i] = new Elevator(i+1,maxweight,flrnum);
    }
    elevators = elevarr;
}

ElevatorControlSystem::~ElevatorControlSystem(){
    delete this;
}

void ElevatorControlSystem::flrreq(string direction,int serveflrnum){

}
void ElevatorControlSystem::atnewflr(int flrnum, int elevnum){

}
void ElevatorControlSystem::elevreq(int destflrnum,int elevnum){

}
void ElevatorControlSystem::elevreq(string safetyissue, int elevnum){

}
void ElevatorControlSystem::opportunisticstrat(){

}


