/*
FILE IS main2D.c

Purpose:
a. Practice memory allocation of a 2D array and populating it.

Description:
See tutorial notes

History:
20/1/2018 Doron Nussbaum modified the file

2018 copyright Doron Nussbaum

*/
#include "stdio.h"
#include "stdlib.h"
#include "string.h"


#define DIM_1   10 
#define DIM_2    5 



int main(int argc, char **argv)

{

    int i,j;
    int count = 0;
    int rc = 0; 
    int **arr = NULL;

    
    // allocate memory for the arrray of pointers to int array
    // the array has to have DIM_1 elements where each element is an int *
    // add code
    //
    arr = (int **) malloc(sizeof(int *) * DIM_1);


    // initialize the pointers to NULL
    for (i = 0; i < DIM_1; i++) arr[i] = NULL;
        
    
    // allocate memory for each element in the array arr
    // each element should contains the address of a 1D array of DIM_2 elements each of type int 
    for (i = 0; i < DIM_1; i++) {//going through each row
        arr[i]= (int *) malloc(sizeof(int) * DIM_2);//creating columns for each row
        if (arr[i] == NULL) {
        	printf("error: could not allocate memory for the array \n");
		return(1);
        }
			// allocate memory for arr[i]
			// check if the memory was allocated
    }

    
    // populate the array (using 2 for loops) 
    count = 1;
	// outer loop of size DIM_1
			// inner loop of size DIM_2
				  // set array element to count
				  //  increment count by 1
	for (i = 0; i < DIM_1; i++){
		for (j = 0; j < DIM_2; j++){
			arr[i][j] = count;
			count++;
		}   	
	}
    // add code 

    // print the array  (using 2 for loops)
    //  Add code
   	for (i = 0; i < DIM_1; i++){
    		//printf("%d\n",*arr[i]);
    		for (j = 0; j < DIM_2; j++){
			printf("%d\n",arr[i][j]);
			
		}   
			
   	}
   	for(int i = 0 ; i < DIM_1 ; i++) {
    		free(arr[i]);
   	}
    
    	free(arr);
    return(0);
}


