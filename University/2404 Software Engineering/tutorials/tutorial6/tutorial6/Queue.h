#ifndef QUEUE_H
#define QUEUE_H

#include "Student.h"

class Queue
{
  class Node
  {
    public:
      Student* data;
      Node*    next;
  };

  public:
    Queue();
    ~Queue();

    bool isEmpty();//done
    void peekFirst(Student** loc);//done
    void popFirst(Student** loc);//done
    void addLast(Student* loc);//done
    void print() const;

  private:
    Node* head;
    Node* tail;
};

#endif

