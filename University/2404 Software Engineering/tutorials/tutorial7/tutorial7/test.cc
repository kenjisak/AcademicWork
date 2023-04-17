#include <istream>
#include <string>

#include "defs.h"
#include "Location.h"
#include "StoreLocation.h"

#define ARR 3

using namespace std;



void labelTest();
void addTest();
void removeTest();
void polymorphismTest();

int main(){

  
    int choice = 0;
    cin >> choice;
    switch(choice){
      case 0: labelTest(); break;
      case 1: addTest(); break;
      case 2: removeTest(); break;
      case 3: polymorphismTest(); break;
    }
    return 0;
  
}

void labelTest(){
  StoreLocation loc[ARR];
  for (int i = 0; i < ARR; ++i){
    loc[i].print();
  }
}

void addTest(){
  StoreLocation loc;
  string product;
  int quantity;
  cin >> product >>quantity;
  loc.add(product, quantity);
  loc.print();

}

void removeTest(){
  StoreLocation loc;
  string product;
  int quantity;
  int remove;
  cin >> product >>quantity>>remove;
  loc.add(product, quantity);
  loc.remove(remove);
  loc.print();

}

void polymorphismTest(){
  StoreLocation loc;
  Location& l = loc;
  string product;
  int quantity;
  cin >> product >>quantity;
  l.add(product, quantity);
  l.print();

}
