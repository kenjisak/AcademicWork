#include "Weapon.h"

Weapon::Weapon(){
    name = "Character Name";
    health = 5.0;
 
}
Weapon::Weapon(string name){
    this->name = name;
}
Weapon::Weapon(Weapon& Weapon){//deep const
    name = Weapon.name;
}
