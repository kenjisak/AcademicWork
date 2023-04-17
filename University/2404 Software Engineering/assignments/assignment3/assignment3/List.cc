#include <iostream>
#include <string>
using namespace std;

#include "List.h"

List::List() : head(NULL) { }

List::~List()
{
  Node* currNode;
  Node* nextNode;

  currNode = head;

  while (currNode != NULL) {
    nextNode = currNode->next;
    delete currNode->data;
    delete currNode;
    currNode = nextNode;
  }
}

void List::add(Product* prod)
{
  Node* newNode;
  Node* currNode;
  Node* prevNode;

  newNode = new Node;
  newNode->data = prod;
  newNode->next = NULL;

  currNode = head;
  prevNode = NULL;

  while (currNode != NULL) {
    if (newNode->data->getName() < currNode->data->getName())
      break;
    prevNode = currNode;
    currNode = currNode->next;
  }

  if (prevNode == NULL)
    head = newNode;
  else
    prevNode->next = newNode;

  newNode->next = currNode;
}

void List::del(const string& name, Product** goner)
{
  Node* currNode;
  Node* prevNode;

  currNode = head;
  prevNode = NULL;

  while (currNode != NULL) {
    if (currNode->data->getName() == name)
      break;
    prevNode = currNode;
    currNode = currNode->next;
  }

  if (currNode == NULL) {
    *goner = NULL;
    return;
  }

  if (prevNode == NULL) 
    head = currNode->next;
  else
    prevNode->next = currNode->next;

  *goner = currNode->data;
  delete currNode;
}

void List::print() const
{
  Node* currNode = head;

  while (currNode != NULL) {
    currNode->data->print();
    currNode = currNode->next;
  }
}

bool List::isEmpty(){
    return head == NULL;
}
void List::findProduct(const string& name, Product** prod){
    Node* currNode = head;
    Node* nextNode;
    bool found = false;
    
    while (currNode != NULL) {
        if (currNode->data->getName() == name){
            *prod = currNode->data;
            found = true;
            break;
        }
        nextNode = currNode->next;
        currNode = nextNode;
    }

    if (!found){
        prod = NULL;
    }
}

