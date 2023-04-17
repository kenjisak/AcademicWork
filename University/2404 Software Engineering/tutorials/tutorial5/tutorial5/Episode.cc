#include "Episode.h"

Episode::Episode(const string& podcast, int number, const string& name,const string& content){
    namem = name;
    contentm = content;
    podcastm = podcast;
    numberm = number;
}
Episode::Episode(){
    namem = "name";
    contentm = "content";
    podcastm = "podcast";
    numberm = 0;
}
Episode::Episode(Episode& e){
    namem = e.namem;
    contentm = e.contentm;
    podcastm = e.podcastm;
    numberm = e.numberm;
}

void Episode::play(){
    std::cout<<"\n>Podcast info: "<<podcastm<<"\n>Episode name: " << namem<< "\n>Episode number: "<<numberm<<"\n>Episode content: "<< contentm<<"\n"<<std::endl;
}
void Episode::print(){
    play();
}