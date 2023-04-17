#ifndef NETWORK_H
#define NETWORK_H

#include <iostream>
#include <string>
#include "PodArray.h"
#include "Subscriber.h"
#include "defs.h"
using namespace std;

class Network{
    private:

		//variables
        string name;
		PodArray* podarray;
        Subscriber* subarray[MAX_SUBS];
        int numSubs;
	
	public:
		//constructor
		Network();
        Network(string title);
		~Network();		
        //getters
        bool getPodcast(string podcastname, Podcast** pod);
        bool hasSubscriber(string name);//removed an arg
        //add and remove
        bool addPodcast(string podcast, string host);
        bool removePodcast(string podcast);
        bool addEpisode(string podcast, string title, string content);
        bool addSubscriber(string name, string creditcard);
        //client services
        bool download(string subscriber, string podcast, Podcast** pod);
        bool stream(string subscriber, string podcast, int epNum, Episode** ep);
	    //functions
        void print();

};

#endif