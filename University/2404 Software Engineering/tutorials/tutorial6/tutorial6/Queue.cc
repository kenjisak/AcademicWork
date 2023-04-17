#include <iostream>
#include <string>
using namespace std;

#include "Queue.h"

Queue::Queue() { 
    head = NULL;
    tail = NULL;
}

Queue::~Queue()
{
    Node* currNode = head;
    Node* nextNode;

    while (currNode != NULL) {
        nextNode = currNode->next;
        delete currNode;
        currNode = nextNode;
    }
}
bool Queue::isEmpty(){
    return head == NULL;
}
void Queue::peekFirst(Student** loc){
    if (head != NULL){
        *loc = head->data;
    }else{
        *loc = NULL;
    }
}

void Queue::popFirst(Student** loc)
{
    Node* delNode;
    if (head == NULL){
        *loc = NULL;
    }else{
        delNode = head;
        *loc = delNode->data;
        head = head->next;
        delete delNode;
    }
  
}
void Queue::addLast(Student* stu)
{
    Node* newNode = new Node;
    
    newNode->data = stu;
    newNode->next = NULL;


    if (head == NULL){// if empty
        head = newNode;
        tail = newNode;
        newNode = NULL;
    }else{
        tail->next = newNode;//set to new node
        tail = newNode;//tail data is new node and tail next is null
    }
    /*
    //add to last node
    currNode = head;//head
    prevNode = NULL;//null no prev for now

    while (currNode != NULL) { //if theres a head node traverse get next
        prevNode = currNode;//head is now prev
        currNode = currNode->next;//curr is now next 
    }

    if (prevNode == NULL){//if head was null doesnt go into for loop so prevnode isnt changed from null
        //if first node added
        head = newNode;
        tail = newNode;
    }else{//set next node to new node if prev node is changed and grabs last node
        prevNode->next = newNode;//head next = new node
    }
    newNode->next = currNode;// set to null since last 
    */
}

void Queue::print() const
{
  Node* currNode = head;

  while (currNode != NULL) {
    currNode->data->print();
    currNode = currNode->next;
  }
}

