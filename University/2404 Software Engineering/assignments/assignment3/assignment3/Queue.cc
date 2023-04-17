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
void Queue::peekFirst(WHLocation** loc){
    if (head != NULL){
        *loc = head->data;
    }else{
        *loc = NULL;
    }
}

void Queue::popFirst(WHLocation** loc)
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
void Queue::addLast(WHLocation* loc)
{
    Node* newNode = new Node;
    
    newNode->data = loc;
    newNode->next = NULL;


    if (head == NULL){// if empty
        head = newNode;
        tail = newNode;
        newNode = NULL;
    }else{
        tail->next = newNode;//set to new node
        tail = newNode;//tail data is new node and tail next is null
    }
}

void Queue::print() const
{
  Node* currNode = head;

  while (currNode != NULL) {
    currNode->data->print();
    currNode = currNode->next;
  }
}

