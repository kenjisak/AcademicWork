#include "Podcast.h"

Podcast::Podcast(string title,string host){
    this->title = title;
    this->host = host;
    episodes = new Episode*[MAX_EPS];
    numEps = 0;
}
Podcast::Podcast(Podcast& pod){
    title = pod.title;
    host = pod.host;
    numEps = pod.numEps;
    episodes = new Episode*[MAX_EPS];

    for(int i = 0; i < numEps; i++){
        this->episodes[i] = new Episode(*pod.episodes[i]);
    }
}
Podcast::~Podcast(){
    for (int i = 0; i < MAX_EPS; i++){
        delete episodes[i];
    }
    delete [] episodes;
}
string Podcast::getTitle(){
    return title;
}
string Podcast::getHost(){
    return host;
}
int Podcast::getNumEpisodes(){
    return numEps;
}
bool Podcast::addEpisode(string title,string content){
    if (numEps <= MAX_EPS) {
        episodes[numEps] = new Episode(this->title,numEps , title,content);
        numEps++;
        return true;
        
    }else return false;
}
bool Podcast::getEpisode(int index, Episode** ep){
    if (index <= numEps){
        *ep = episodes[index];
        return true;
    }else{
        return false;
    }
}
bool Podcast::lessThan(Podcast& pod){
    return title < pod.title;
}
void Podcast::print(){
    cout << title <<" "<< host << " " << numEps <<endl;
}