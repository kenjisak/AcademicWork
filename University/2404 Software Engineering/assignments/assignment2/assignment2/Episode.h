#ifndef EPISODE_H
#define EPISODE_H

#include <iostream>
#include <string>

using namespace std;

class Episode{
    private:

		//variables
        string namem;
		string contentm;
        string podcastm;
        int numberm;
	
	public:
		//constructor
		Episode();
		Episode(const string& podcast, int number, const string& name,const string& content);
		Episode(Episode&);		
		//setters	
		//getters
	    //functions
        void print();
        void play();
};

#endif