//createVertices
//createEdges
//removeEdges
//cleanupEverything
#include <stdio.h>
#include <stdlib.h>

#include "obstacles.h"
#include "display.h"

void createVertices(Environment *env){
    env->numVertices = env->numObstacles*4;
    printf("%d num vertices = " +  env->numVertices);//sets num of total vertices in graph
    env->vertices=(Vertex *)malloc(env->numVertices*sizeof(Vertex));//allocates 28 spaces of memory for vertices
    for (int i=0; i<env->numObstacles; i++) {//7 obstacles
        for (int i = 0; i< env->numVertices; i++  ){
            env->vertices[i].x = env->obstacles[i].x;//set each vertice x and y
		    env->vertices[i].y = env->obstacles[i].y;
            env->vertices[i].firstNeighbour = env->vertices;//set first neighbour and last neighbour.
        }
	}
}
void createEdges(Environment *env){

}
void removeEdges(Environment *env){

}
void cleanupEverything(Environment *env){

}