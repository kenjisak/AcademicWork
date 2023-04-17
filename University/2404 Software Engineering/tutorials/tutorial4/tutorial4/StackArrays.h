#ifndef STACKARRAYS_H
#define STACKARRAYS_H

#include <iostream>
#include <string>
#include "Episode.h"
#include "defs.h"
using namespace std;

class StackArrays{

    public:
        StackArrays();
        ~StackArrays();

        Episode* getObjectArray();
        Episode** getPointerArray();
    private:
        //variables
        Episode episodeobjects[ARR_SIZE];
        Episode* episodepointers[ARR_SIZE];
};

#endif