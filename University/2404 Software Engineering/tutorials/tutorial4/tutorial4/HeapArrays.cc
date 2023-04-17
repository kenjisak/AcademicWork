#include "HeapArrays.h"

HeapArrays::HeapArrays(){
    episodeobjects = new Episode[ARR_SIZE];//init
    episodepointers = new Episode*[ARR_SIZE];//init
    for (int i = 0; i < ARR_SIZE; i++)
    {
        episodepointers[i] = new Episode();
    }
}

HeapArrays::~HeapArrays(){
    delete[] episodeobjects;
    for (int i = 0; i < ARR_SIZE; i++)
    {
        delete episodepointers[i];
    }
    delete[] episodepointers;
}

Episode* HeapArrays::getObjectArray(){
    return episodeobjects;
}

Episode** HeapArrays::getPointerArray(){
    return episodepointers;
}