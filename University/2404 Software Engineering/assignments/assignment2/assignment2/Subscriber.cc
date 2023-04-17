#include "Subscriber.h"

Subscriber::Subscriber(string name, string creditcard){
    this->name = name;
    this->creditcard = creditcard;
}
void Subscriber::print(){
    cout<< name << creditcard <<endl;
}
string Subscriber::getName(){
    return name;
}
bool Subscriber::matches(const string& name){
    return this->name == name;
}