#include <istream>
#include <string>

#include "defs.h"
#include "Student.h"
#include "Queue.h"

#define ARR 3

using namespace std;

const string names[5] = {"Abe","Bae","Cedric","Deb","Elise"};
const string numbers[5] = {"000","111","222","333","444"};

int orderTest();
int edgeTest();

int main(){

  
    int choice = 0;
    cin >> choice;
    int ret = 0;
    switch(choice){
      case 0: ret = orderTest(); break;
      case 1: ret = edgeTest(); break;
    }

    return ret;
  
}

int orderTest(){
  Student* stu[5];
  for (int i = 0; i < 5; ++i){
    stu[i] = new Student(names[i],numbers[i]);
  }
  Queue* q = new Queue();

  cout<<"Adding 5 students to q"<<endl;
  for (int i = 0; i < 5; ++i){
      q->addLast(stu[i]);
  }

  Student* st;

  cout<<"Removing 5 students from q"<<endl;
    
  for (int i = 0; i < 5; ++i){
      q->popFirst(&st);
      if (st != stu[i]){
        cout<<"Error, wrong order"<<endl;
        return 1;
      }
  }


    delete q;
    for (int i = 0; i < 5; ++i){
      delete stu[i];
    }
    return 0;
}

int edgeTest(){
  Queue* q = new Queue();
  if(q->isEmpty()){
        cout<<"Queue is empty!"<<endl;
  }else{
        cerr<<red<<"Error: Queue not empty!"<<def<<endl;
        return 1;
  }
  Student* stu[5];
  for (int i = 0; i < 5; ++i){
      stu[i] = new Student(names[i],numbers[i]);
      q->addLast(stu[i]);
  }
 

  Student* st;

  cout<<"Deleting all but one student ..."<<endl;
  for (int i = 0; i < 4; ++i){
      q->popFirst(&st);
  }

  q->peekFirst(&st);

  if (st!= stu[4]){
      cout<<"Error, wrong student left"<<endl;
      return 1;
  }

  cout<<"Adding back 4 students"<<endl;
  for (int i = 0; i < 4; ++i){
      q->addLast(stu[i]);
  }

  q->peekFirst(&st);
  if (st!= stu[4]){
      cout<<"Error, wrong student in front"<<endl;
      return 1;
  }

  cout<<"Deleting all students"<<endl;
  for (int i = 0; i < 5; ++i){
      q->popFirst(&st);
  }

  q->peekFirst(&st);

  if (st!= NULL){
      cout<<"peekFirst should return NULL on empty Queue"<<endl;
      return 1;
  }

  cout<<"Adding back 5 students"<<endl;
  for (int i = 0; i < 5; ++i){
      q->addLast(stu[i]);
  }

  q->peekFirst(&st);
  if (st!= stu[0]){
      cout<<"Error, wrong student in front"<<endl;
      return 1;
  }
  
  cout<<"Printing queue..."<<endl;

  q->print();

  cout<<"Tests complete"<<endl;

  delete q;



  for (int i = 0; i < 5; ++i){
      delete stu[i];
  }

  return 0;

}


