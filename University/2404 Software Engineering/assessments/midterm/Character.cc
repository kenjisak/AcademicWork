//Character.cc begins
#include "Character.h"

Character::Character(){
    name = "Character Name";
    health = 10;
    characterweapon = new Weapon();
}
Character::Character(string name,int health){
    this->name = name;
    this->health = health;
    characterweapon = new Weapon();
}
Character::Character(Character& character):name(character.name),health(character.health){//deep const
    this->characterweapon = new Weapon(*character.characterweapon);
}
Character::~Character(){
    delete characterweapon;
}
//Character.cc ends