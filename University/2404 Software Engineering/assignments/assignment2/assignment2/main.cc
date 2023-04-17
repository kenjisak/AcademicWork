#include <iostream>
#include "Podcast.h"
#include "PodArray.h"
#include "TestControl.h"

using namespace std;

int main(){
	
	TestControl* control = new TestControl();

	control->launch();
	
	delete control;
	
	/*
	Podcast* pod; 

    PodArray* parray = new PodArray();
	
    parray->addPodcast(pod = new Podcast("title1","host1"));
    cout<<"podcast added!"<<endl;
    
	parray->addPodcast(pod = new Podcast("title2","host2"));
    cout<<"podcast added!"<<endl;
	
	parray->addPodcast(pod = new Podcast("title3","host3"));
    cout<<"podcast added!"<<endl;

	parray->addPodcast(pod = new Podcast("title4","host4"));
    cout<<"podcast added!"<<endl;

	cout<< parray->size()<<endl;
	parray->print();

	Podcast* podremove;
	parray->removePodcast("title2",&podremove);

	cout<< parray->size()<<endl;
	parray->print();
	*/
	return 0;
}
