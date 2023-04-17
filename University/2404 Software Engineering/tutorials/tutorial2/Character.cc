#include "Character.h"

//constructor
Character::Character(string n, int mh, int dmg){
    setCharacter(n, mh, dmg);
}
Character::Character(Character& c){
	setCharacter(c.name,c.maxHealth,c.damage);
}


//setters
void Character::setmaxHealth(int mh){
    maxHealth = mh;
}
void Character::setcurrentHealth(int ch){
    currentHealth = ch;
}
void Character::setdamage(int dmg){
    damage = dmg;
}
void Character::setCharacter(string n, int mh, int dmg){
    name = n;
    maxHealth = mh;
    damage = dmg;
}
void Character::setCharacter(Character& c){
    c.name = "yaboi";
    maxHealth = 1000;
    damage = 10;
}


//getters
string Character::getName(){
	return name;
}
int Character::getmaxHealth(){
    return maxHealth;
}
int Character::getcurrentHealth(){
    return currentHealth;
}

//functions
void Character::takeDamage(int damage){
   if(currentHealth - damage < 0 ){
       currentHealth = 0;
   }else{
       currentHealth = currentHealth - damage ;
   }
}
int Character::strike(){
    return damage;
}
void Character::print(){
    cout<<"Character name: "<<name<<"\n"<<name<<"'s current health: "<< currentHealth;
}
