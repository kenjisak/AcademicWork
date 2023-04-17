#include <iostream>
#include <string>
#include <cstdlib>


using namespace std;
//Q1
/*
class Car{
    public:
        int wheels;
    protected:
        int doors;
    private:
        int pistons;
};

class Electric: private Car{};

class Tesla: public Electric{
    void upgrade(){
        //wheels++;
        //doors++;
        //pistons++; 
    }
};
int main(){
    Tesla ts;
    //int ass = ts.wheels;
    //int ass = ts.doors;
    //int ass = ts.pistons;
    return 0;
}
*/
//only wheels would not cause a compiler error first part
//2nd part depends which type of inheritance then diff compilation errors
class Car{
    public:
        void accelerate(){
            ++speed;
        }
        private:
            int speed;
};

class Electric:public Car{
    void accelerate(){
        ++voltage;
        Car::accelerate();
    }
    private:
        int voltage;
};