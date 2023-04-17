#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <string>

using namespace std;

class Episode{ 
    public: 
        Episode(const string& name, const string& captions); 
    private: 
        string name; 
        string captions; 
}; 
 
class Show { 
    public: 
        Show(const string& name): name(name), numEpisodes(0), episodes(new Episode*[256]){} 
        Show(Show& show); 
        void addEpisode(const string& name, const string& captions){ 
            episodes[numEpisodes++] = new Episode(name, captions); 
        } 
    private: 
        string name; 
        Episode** episodes; 
        int numEpisodes; 
};
#endif