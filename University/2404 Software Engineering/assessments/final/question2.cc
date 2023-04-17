#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;
//Q2
class Aircraft { }; 
class Helicopter : public Aircraft { }; 
class Plane : public Aircraft { }; 
class Cessna : public Plane { }; 

 
int main(){ 
    int blah = 1;
    try{   
        throw Helicopter();
    } catch(Plane& a) { 
        cout<<"Plane alert!"<<endl; 
    } catch(Cessna& a) { 
        cout<<"Cessna alert!"<<endl;
    } catch(Aircraft& a) { 
        cout<<"Aircraft alert!"<<endl; 
    } catch(Helicopter& a) { 
        cout<<"Helicopter alert!"<<endl; 
    } catch(...){ 
        cout<<"ufo something"<<endl; 
    } 
    return 0; 
}

//"Animal Alert!" since pig alert is below animal catch
//depending on if pig alert or animal alert is top then itll return those catch
//output would be caught something
