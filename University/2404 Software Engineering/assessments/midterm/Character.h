//Character.h begins
#ifndef CHARACTER_H
#define CHARACTER_H

#include <iostream>
#include <string>
#include "Weapon.h"
using namespace std;

class Character{
		
	public:
		//constructor
		Character();
		Character(string name,int health);
        Character(Character&);
        ~Character();
	
	private:
		//variables
		string name;
		int health;
		Weapon* characterweapon;
};
#endif
//Character.h ends