#ifndef PODCAST_H
#define PODCAST_H

#include <iostream>
#include <string>
#include "Episode.h"
#include "defs.h"
using namespace std;

class Podcast{
    private:
		//variables
        string title;
		string host;
        Episode** episodes;
        int numEps;
	
	public:
		//constructor
		Podcast(string title,string host);
		Podcast(Podcast&);	
        ~Podcast();		
		//getters
        string getTitle();
        string getHost();
        int getNumEpisodes();
	    //functions
        bool addEpisode(string title,string content);
        bool getEpisode(int index, Episode** ep);
        bool lessThan(Podcast& pod);
        void print();
     
};

#endif