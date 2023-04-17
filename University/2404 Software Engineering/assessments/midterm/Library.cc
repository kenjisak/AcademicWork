#include "Library.h"

Library::Library(const string& name){
    this->name = name;
    books = new Book*[MAX];
    numBooks = 0;
}
//deep copy
Library::Library(const Library& lib):name(lib.name),numBooks(lib.numBooks){
    //name = lib.name;
    //numBooks = lib.numBooks;
    books = new Book*[MAX];
    for(int i = 0; i < numBooks; i++){
        this->books[i] = new Book(*lib.books[i]);
    }
}
Library::~Library(){
    for (int i = 0; i < numBooks; i++){
        delete books[i];
    }
    delete [] books;
}
/*
GameLibrary::GameLibrary(const GameLibrary& gamelib):name(gamelib.name),numGames(gamelib.numGames){
    for(int i = 0; i < numGames; i++){
        this->games[i] = new Game(*gamelib.games[i]);
    }
}

GameLibrary::~GameLibrary(){
    for (int i = 0; i < numGames; i++){
        delete games[i];
    }
    delete [] games;
}
*/