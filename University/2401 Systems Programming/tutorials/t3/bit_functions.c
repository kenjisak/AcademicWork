
/* file is bit_functions.c 
Purpose: helper functions for bit manipulation

*/

#include "bit_functions.h"




/*
Purpose: checks if bit in position bitNum of the character c is set to 1 
input:
c - a character
bitNum - the bit position

return
1 if the bits is set
0 is the bit is not set

*/
int isBitSet(unsigned char c, int bitNum) 
{
	if (c & (1<< bitNum)){
		return 1;
	}else{
		return 0;
	}
}


/***************************************************************/


/*
Purpose: sets bit in position bitNum of the character c to 1 
input:
c - a character 
bitNum - the bit position

return
the modified character

*/
unsigned char setBit(unsigned char c, int bitNum) 
{
	return c = c | (1<< bitNum);
	
	
}


/***************************************************************/

/*
Purpose: clears bit in position bitNum of the character c 
input:
c - a character upon
bitNum - the bit position

return
the modified character

*/

unsigned char clearBit(unsigned char c, int bitNum) 
{
	return c = c & ~(1 << bitNum);
}


/***************************************************************/

/*
Purpose: prints the bits of the the character using an iterative method 
input:
c - a character that its bits must be printed

return
none

*/

void printBitsIterative(unsigned char c) 
{
	for (int bitNum = 7; bitNum >= 0 ; bitNum--){
		if (isBitSet(c,bitNum) == 1){
			printf("1");
			
		}else{
			printf("0");
		}
	}
	printf("\n");
}

/***************************************************************/


/*
Purpose: prints the bits of the the character using recurive method
input:
c - a character that its bits must be printed

return
none

*/

void printBitsRecursive(unsigned char c) 
{
	
	//base case
	
	if((isBitSet(c,0) == 0) && (isBitSet(c,1) == 0) && (isBitSet(c,2) == 0) && (isBitSet(c,3) == 0) && (isBitSet(c,4) == 0) && (isBitSet(c,5) == 0) && (isBitSet(c,6) == 0) && (isBitSet(c,7) == 0)){
		printf("\n");
		return ;
	}
	if (isBitSet(c,7) == 1){
		printf("1");
		
	}else{
		printf("0");
	}
	
	
	//recursive step
	
		printBitsRecursive(c << 1);	
	
}

