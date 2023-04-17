
#ifndef CHARACTER_H
#define CHARACTER_H

#include <iostream>
#include <string>

using namespace std;

class Character {
		
	public:
		//constructor
		Character(string name = "ya boi",int maxHealth = 100, int damage = 10);
		Character(Character&);
		
		//setters
		void setmaxHealth( int);
		void setcurrentHealth(int);
		void setdamage(int);
		void setCharacter(string, int, int);
		void setCharacter(Character&);
		
		//getters
		string getName();
		int getmaxHealth();
		int getcurrentHealth();
		int getdamage();

	    //functions
		void takeDamage(int damage);
        int strike();
        void print();
	private:
		

		//variables
        string name;
		int maxHealth;
		int damage;
		int currentHealth;

};
#endif