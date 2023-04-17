#include<iostream>
#include<string>

using namespace std;

int main(){
	int sum,num1,num2;
	cout << ">Please enter two integers: ";
	cin >> num1 >> num2;
	sum = num1*num2;
	cout <<"\n>The product of " << num1 << " and " << num2 << " is " << sum << "!";
	return 0;
}
