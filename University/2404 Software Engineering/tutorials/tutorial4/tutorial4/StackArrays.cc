#include "StackArrays.h"

StackArrays::StackArrays(){
    for (int i = 0; i < ARR_SIZE; i++)
    {
        episodepointers[i] = new Episode();
    }
}
StackArrays::~StackArrays(){
    for (int i = 0; i < ARR_SIZE; i++)
    {
        delete episodepointers[i];
    }
}
Episode* StackArrays::getObjectArray(){
    return episodeobjects;
}
Episode** StackArrays::getPointerArray(){
    return episodepointers;
}