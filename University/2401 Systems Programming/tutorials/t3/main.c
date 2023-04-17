#include <stdio.h>
#include "bit_functions.h"


int main() 
{
    unsigned char a = 'A';
	
    int num = isBitSet(a,1);
    printf("isbitset %d \n", num);
    printBitsIterative(a);
    printf("setting bits 2 and 3 \n");
    a = setBit(a, 2);
    a = setBit(a, 3);
    int task2 = isBitSet(a,3);
    printf("setbit %d \n", task2);
    printBitsIterative(a);

    printf("clearing bit 2 \n");
    a = clearBit(a, 2);
    a = clearBit(a, 1);
    int task3 = isBitSet(a,1);
    printf("clearbit %d \n", task3);
    printBitsRecursive(a);

    return 0;
}
 

