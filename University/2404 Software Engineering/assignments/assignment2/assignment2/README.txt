Kenji Isak Laguan
101160737

main.cc 
- launches test control to start testing this assignment
Client.cc
- download func deep copy downloads podcast from network class and adds it to its own member var array so when deleted from network its still there locally
- stream func streams podcast from network doesnt save data
- playLocal func prints data usoing its own member data and not from network
Client.h
- header file with declarations of functions and member variables for its class
defs.h
- header file with declarations of member variables used for multiple classes
Episode.cc 
- episode with data 
- prints out episode info
Episode.h 
- header file with declarations of functions and member variables for its class
Network.cc 
- can contain info for podcasts and episodes.
- can add podcasts,episodes, subscribers. and remove a podcastcan download info,stream and check if the user is a subscriber
Network.h 
- header file with declarations of functions and member variables for its class
PodArray.cc 
- contains info for the podcasts in an array. can add or remove them and get info about them.
PodArray.h 
- header file with declarations of functions and member variables for its class
Podcast.cc
- podcasts data with episode data
Podcast.h 
- header file with declarations of functions and member variables for its class
Subscriber.cc 
- subscriber data
Subscriber.h 
- header file with declarations of functions and member variables for its class
TestControl.cc 
- contains test functions to test the classes above
TestControl.h 
- header file with declarations of functions and member variables for its class
TestView.cc 
- user control that calls the test control functions depending on user input
TestView.h 
- header file with declarations of functions and member variables for its class
Makefile
- compiles all these files together into one executable to run