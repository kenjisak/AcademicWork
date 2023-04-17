
#include "PodArray.h"

PodArray::PodArray(){
	numPods = 0;
	podcasts = new Podcast*[MAX_PODS];
}

PodArray::PodArray(PodArray& pa){
	podcasts = new Podcast*[MAX_PODS];
	for (int i =0 ; i < pa.numPods; ++i){
		podcasts[i] = new Podcast(*pa.podcasts[i]);
	}
	numPods = pa.numPods;

}


PodArray::~PodArray(){
	for (int i = 0; i < numPods; ++i){
		delete podcasts[i];
	}
	delete [] podcasts;
}

bool PodArray::addPodcast(Podcast* p){
	if (numPods >= MAX_PODS) return false;
	for (int i = numPods; i > 0; --i){
		if (p->lessThan(*podcasts[i-1])){
			podcasts[i] = podcasts[i-1];
		}else{
			podcasts[i] = p;
			++numPods;
			return true;
		}
	}
	podcasts[0] = p;
	++numPods;
	return true;
}

bool PodArray::removePodcast(const string& title, Podcast** pod){
	for (int i = 0; i < numPods; ++i){//10 numpods goes up to 9
		if (podcasts[i]->getTitle() == title){//3
			*pod = podcasts[i];//sets return podcast to the podcast to delete
			delete podcasts[i];

			if (i != numPods - 1){//if not last element
				for (int x = i; x < numPods - 1; x++){//x = 3; x < 9; x++
					podcasts[x] = podcasts[x+1]; //8 = 9
				}//updates and shifts the array
			}
			numPods--;
			return true;
		}
	}
	return false;
}

bool PodArray::getPodcast(const string& title, Podcast** pod){
	for (int i = 0; i < numPods; ++i){
		if (podcasts[i]->getTitle() == title){
			*pod = podcasts[i];
			return true;
		}
	}
	return false;
}

bool PodArray::isFull(){
	return numPods >= MAX_PODS;
}

int PodArray::size(){
	return numPods;
}

void PodArray::print(){
	for (int i = 0; i < numPods; ++i){
		cout<<i<<endl;
		podcasts[i]->print();
	}
}
