#include <iostream>
#include <string>
#include <cstdlib>

using namespace std; 
class RAM{ 
    public: 
        RAM():gbs(0){cout<<"RAM ctor"<<endl;}
        ~RAM(){cout<<"RAM dtor"<<endl;} 
    private:
    int gbs;
}; 
class Computer{ 
    public: 
        Computer(){cout<<"Computer ctor"<<endl;} 
        ~Computer(){cout<<"Computer dtor"<<endl;} 
    private:
    RAM ram;
}; 
class Homebuilt: public Computer{ 
    public: 
        Homebuilt(){cout<<"Homebuilt ctor"<<endl;} 
        ~Homebuilt(){cout<<"Homebuilt dtor"<<endl;} 
}; /*
class Egg: public Bird{ 
    public: 
        Egg(){cout<<"Egg ctor"<<endl;} 
        ~Egg(){cout<<"Egg dtor"<<endl;} 
}; 
class Pig: public Animal{ 
    public: 
        Pig(){cout<<"Pig ctor"<<endl;} 
        ~Pig(){cout<<"Pig dtor"<<endl;} 
};
 */
int main(){ 
    Homebuilt hb;
    //Pig pig;
    //Egg egg;
    return 0; 
}
// output of given code
/* -    Animal ctor
        Animal ctor
        Bird ctor
        Bird dtor
        Animal dtor
        Animal dtor 
*/
//output if more animals
/* -    Animal ctor
        Animal ctor
        Bird ctor
        Animal ctor
        Pig ctor
        Pig dtor
        Animal dtor
        Bird dtor
        Animal dtor
        Animal dtor
*/
//output if egg
/* -    Animal ctor
        Animal ctor
        Bird ctor
        Animal ctor
        Pig ctor
        Animal ctor
        Bird ctor
        Egg ctor
        Egg dtor
        Bird dtor
        Animal dtor
        Pig dtor
        Animal dtor
        Bird dtor
        Animal dtor
        Animal dtor
*/
