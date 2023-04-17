#ifndef CLIENT_H
#define CLIENT_H

#include <iostream>
#include <string>
#include "PodArray.h"
#include "Network.h"

using namespace std;

class Client{
    private:

		//variables
        string name;
		PodArray* podarray;
	
	public:
		//constructor
		Client();
        Client(string name);
		~Client();		
        //client services
        bool download(Network* network, string podcast);
        bool stream(Network* network, string podcast, int episode);
	    bool playLocal(string podcast, int episode);
        //functions
        void print();

};

#endif