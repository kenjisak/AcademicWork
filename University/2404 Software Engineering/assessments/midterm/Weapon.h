
#ifndef WEAPON_H
#define WEAPON_H

#include <iostream>
#include <string>

using namespace std;

class Weapon{
		
	public:
		//constructor
		Weapon();
		Weapon(string name);
        Weapon(Weapon&);
	
	private:
		//variables
		string name;
		int health;

};
#endif
