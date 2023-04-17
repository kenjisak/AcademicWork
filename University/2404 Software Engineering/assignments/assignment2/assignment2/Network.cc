#include "Network.h"

Network::Network(){
    name = "";
    podarray = new PodArray();
    for (int i = 0; i < MAX_SUBS; i++){
        subarray[i] = NULL;
    }
    numSubs = 0;
}
Network::Network(string title){
    name = title;
    podarray = new PodArray();
    for (int i = 0; i < MAX_SUBS; i++){
        subarray[i] = NULL;
    }
    numSubs = 0;
}
Network::~Network(){
    name = "";
    delete podarray;
    for (int i = 0; i < MAX_SUBS; i++){
        delete subarray[i];
    }
    //delete [] subarray;
    numSubs = 0;
}
bool Network::getPodcast(string podcastname, Podcast** pod){
    return podarray->getPodcast(podcastname, pod);//uses podarray class get
}
bool Network::hasSubscriber(string name){
    for (int i = 0; i < numSubs; ++i){//checks subs through array
		if (subarray[i]->getName() == name){
			//*sub = subarray[i];
			return true;
		}
	}
    return false;
}
bool Network::addPodcast(string podcast, string host){
    Podcast* pod = new Podcast(podcast,host);
    return podarray->addPodcast(pod);//uses podarray class add
}
bool Network::removePodcast(string podcast){
    Podcast* pod;
    return podarray->removePodcast(podcast,&pod);//uses podarray class remove 
}
bool Network::addEpisode(string podcast, string title, string content){
    Podcast* pod;
    if (podarray->getPodcast(podcast,&pod)){
        pod->addEpisode(title,content);
        return true;
    }else return false;
        
}
bool Network::addSubscriber(string name, string creditcard){
    if (numSubs <= MAX_SUBS){//adds new sub to array
        subarray[numSubs] = new Subscriber(name,creditcard);
        numSubs++;
        return true;
    }else return false;
}
bool Network::download(string subscriber, string podcast, Podcast** pod){
    for (int i = 0; i < numSubs;i++){
        if (subarray[i]->getName() == subscriber){//if sub exists
            if (podarray->getPodcast(podcast,pod)){//if podcast exists
                return true;
            }else {
                std::cout<<"no such podcast"<<endl;
                return false;
            }
        }
    }
    std::cout<<"no such subscriber"<<endl;
    return false;
}
bool Network::stream(string subscriber, string podcast, int epNum, Episode** ep){
    Podcast* pod;
    for (int i = 0; i < numSubs;i++){
        if (subarray[i]->getName() == subscriber){//if sub exists
            if (podarray->getPodcast(podcast,&pod)){//if podcast exists
                if(pod->getEpisode(epNum,ep)){//if episode exists
                    return true;
                }else {
                    std::cout<<"no such episode"<<endl;
                    return false;
                }
            }else {
                std::cout<<"no such podcast"<<endl;
                return false;
            }
        }
    }
    std::cout<<"no such subscriber"<<endl;
    return false;
}
void Network::print(){
    cout<< "Network: "<< name << " Number of Subscribers: "<< numSubs <<endl;
    podarray->print();
    for (int i = 0; i < numSubs; i++){
        subarray[i]->print();
    }
}