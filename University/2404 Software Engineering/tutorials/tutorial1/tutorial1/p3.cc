#include<iostream>
#include<string>
#include "power.cc"
using namespace std;

int main(){
    int num,num1,num2;
	cout << ">Please enter two integers: ";
	cin >> num1 >> num2;
	power(num1,num2,num);
	cout <<"\n>"<< num1 << " to the power of " << num2 << " is " << num;
	return 0; 
}