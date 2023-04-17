#pragma once
typedef struct {
	int x;
	int y;
	int w;//should be short?
	int h;
}Obstacle;
typedef struct {
	//x and y coordinate of this vertex
	int x;
	int y;
	//linked list of this vertex neighbours
		//by keeping pointer to first neighbour in the list/head *neighbour types
		//by keeping pointer to last neighbour in the list/tail
	struct Vertex* firstNeighbour;
	struct Vertex* lastNeighbour;
	//pointer to obstacle it belongs to
	Obstacle *obstacle;
}Vertex;
typedef struct {
	//keep pointer to vertex
	Vertex* vertex;
		//keep pointer to next neighbour in list
	Vertex* next;
}Neighbour; 

typedef struct {
	//pointer to a dynamically allocated array of obstacle types and the number of obstacles thats been allocated. * check in other .c how it was allocated cus this is jsut pointer to that
	int numObstacles;
	Obstacle* obstacles;
	//pointer to a dynamically allocated array of vertex type and num of vertexs thats been allocated * same with obstace above
	Vertex* vertices;
	int numVertices;
}Environment;