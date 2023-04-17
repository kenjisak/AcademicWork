#include <iostream>
#include <string>
#include <cstdlib>

#include "question3.h"
using namespace std;

Show::Show(Show& show){
    name = show.name;
    numEpisodes = show.numEpisodes;

	episodes = new Episode*[numEpisodes];
    for(int i = 0; i < numEpisodes; i++){
        this->episodes[i] = new Episode(*show.episodes[i]);
    }
    //arrays with no new key word to init you can just say the index of element to the new array to deep copy
    //arrays with new keyword theyd still look like this
}
