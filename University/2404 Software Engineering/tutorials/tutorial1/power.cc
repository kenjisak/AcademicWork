#include<iostream>
#include<string>
void power(int a,int b, int& c);

using namespace std;

void power(int a,int b, int& c) {
    c = 1;
    for(int x = 1; x <= b;x++){
        c = c*a;
    }
}

