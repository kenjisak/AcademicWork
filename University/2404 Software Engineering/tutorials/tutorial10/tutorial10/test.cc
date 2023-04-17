#include <istream>
#include <string>

#include "defs.h"
#include "Date.h"
#include "Array.h"

using namespace std;

int main(){
  
    Array<Date*> arr;

    if (arr.getSize()!=0){
      cout<<"Error, size of empty array not 0"<<endl;
      return 1;
    }

    cout <<"Adding 30 dates"<<endl;

    for (int i = 0; i < 30; ++i){
        arr.add(new Date(2021,9,i+1));
    }
    
    if (arr.getSize()!=30){
      cout<<"Error, size of array should be 30, instead it is "<<arr.getSize()<<endl;
      return 1;
    }

    if (arr.isFull()){
      cout<<"Error, array (should be size 30) is full. Size: "<<arr.getSize()<<endl;
      return 1;
    }

    cout <<"Deleting all dates"<<endl;

    for (int i = 0; i < 30; ++i){
        delete arr[i];
    }
  
    cout<<"All tests passed"<<endl;
    return 0;
    
  
}



