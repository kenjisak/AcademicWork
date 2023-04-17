#ifndef HEAPARRAYS_H
#define HEAPARRAYS_H

#include <iostream>
#include <string>
#include "Episode.h"
#include "defs.h"
using namespace std;

class HeapArrays{
    public:
        HeapArrays();
        ~HeapArrays();

        Episode* getObjectArray();
        Episode** getPointerArray();
    private:
        //variables
        Episode* episodeobjects;//dynalloc object array
        Episode** episodepointers;//dynalloc object pointer array
};

#endif