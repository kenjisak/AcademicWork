#ifndef ANIMAL_H
#define ANIMAL_H

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class Animal
{
    protected:
        string name;
    public:
        Animal(string name);

        virtual ~Animal();
};

class Human: virtual public Animal
{
    private: 
        int feet;
    public:
        Human(string name,int feet);
};

class Goat: virtual public Animal
{
    private: 
        int feet;
    public:
        Goat(string name,int feet);
};

class Centaur: virtual public Animal, public Human, public Goat
{
    public:
        Centaur(string name,int fh_inspect, int it_inspect);
};
#endif

