#ifndef QUEUE_H
#define QUEUE_H

#include "WHLocation.h"

class Queue
{
  class Node
  {
    public:
      WHLocation* data;
      Node*    next;
  };

  public:
    Queue();
    ~Queue();

    bool isEmpty();//done
    void peekFirst(WHLocation** loc);//done
    void popFirst(WHLocation** loc);//done
    void addLast(WHLocation* loc);//done
    void print() const;

  private:
    Node* head;
    Node* tail;
};

#endif

