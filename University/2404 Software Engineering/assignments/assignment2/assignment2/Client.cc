#include "Client.h"

Client::Client(){
    name = "";
    podarray = new PodArray();
}
Client::Client(string name){
    this->name = name;
    podarray = new PodArray();
}
Client::~Client(){
    delete podarray;
}
bool Client::download(Network* network, string podcast){
    Podcast* pod;
    Podcast* podcopy;
    
    if(network->download(this->name,podcast,&pod)){
        if(podarray->isFull()){//if array isnt full
            std::cout<<"array is full"<<endl;
            return false;
        }else{
            podcopy = new Podcast(*pod);//deep copy so once deleted pointer isnt gone
            podarray->addPodcast(podcopy);
            return true;
        }
    }else{
        std::cout<<"unable to download podcast"<<endl;
        return false;
    }
    
}

bool Client::stream(Network* network, string podcast, int episode){
    Episode* ep;
    if(network->stream(this->name,podcast,episode,&ep)){//using network class to stream and grab the episode pointer
        ep->play();
        return true;
    }else return false;
}
bool Client::playLocal(string podcast, int episode){
    Podcast* pod;
    Episode* ep;
    
    if(podarray->getPodcast(podcast,&pod)){//get episode from client podarray and play
        if(pod->getEpisode(episode,&ep)){
            ep->play();
            return true;
        }else {
            std::cout<< "no such episode"<<endl;
            return false;
        }
    }else {
        std::cout<<"no such podcast"<<endl;
        return false;
    }
}
void Client::print(){
    cout<< name <<endl;
    podarray->print();
}