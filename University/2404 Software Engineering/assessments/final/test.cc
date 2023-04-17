#include <iostream>
using namespace std;
#include <string>
#include <vector>

void func1();
void func2();

int main(){
    try{
        cout<<"calling func1"<<endl;
        func1();
        cout<<"back from func1"<<endl;
    }catch(const char* error){
        cout<<error<<endl;
    }
    return 0;
}

void func1(){
    cout<<"calling func2"<<endl;
    try{
        func2();
    }catch(const char* error){
        cout<<error<<endl;
        throw;
    }
    cout<<"back from func2"<<endl;
}

void func2(){
    cout<<"in func2"<<endl;
    throw "error";
    cout<<"leaving func2"<<endl;
}