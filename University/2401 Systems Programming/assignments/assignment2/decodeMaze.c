#include "stdio.h"
#include "stdlib.h"


void printEncodedMaze(int[], unsigned char);
void printEncodedMazeWithPath(int[], int[], unsigned char);
void encode8by8Maze(char inputMaze[8][8], int encodedMaze[8]);
void merge8by8Mazes(int topLeft[8], int topRight[8], int bottomLeft[8], int bottomRight[8], int finalMaze[14]);
char isPathInMaze(int[], int[], unsigned char);
int main() {
	int encodedmaze[32] = { -1, -2146430423, -1109928277, -1525661045, -1602496045, -1358950569,-1451509759, -1927115297, -1578180479, -1354977603, -1476294999, -2084818261,-1163749757, -1964319689, -1341614619, -1750141691, -1256060947,-1515522751, -1204136611, -1955867371,-1190652827, -1553272339,-1100839163,-1999963019, -631368865, -1882138047,-1172944163, -1412279803, -1567107339,-164346691,-2138762879,-1 };
	int encodedmazepath[32] = { 0, 0, 0, 0, 12, 8, 56, 32, 8032, 4416, 134115648, 67354944, 67109184,67109312, 133169152, 1048576, 1835008, 262144, 262144, 262144, 458752,65536, 65536, 65536, 65536, 983040, 67633152, 67633152, 201850880,164102144, 259522560, 0 };
	int ispathencoded[14] = { 0, 4096, 4096, 4096, 4096, 7936, 256, 256, 448, 112, 16, 28, 6, 0 };
	int encodedmazeone[8];
	int encodedmazetwo[8];
	int encodedmazethree[8];
	int encodedmazefour[8];
	int encoded14maze[14];
	int *encodedmazearray[] = { encodedmazeone,encodedmazetwo,encodedmazethree,encodedmazefour };
	unsigned char wall = 64;//@



	char one[8][8] = { {1,1,1,1,1,1,1,1},
	  {1,0,0,0,1,0,0,1},
	      {1,0,1,0,1,1,0,1},
	  {1,0,1,0,0,0,0,1},
	  {1,0,1,1,1,1,0,1},
	  {1,0,0,0,0,0,0,1},
	  {1,0,1,0,1,0,1,1},
	  {1,1,1,1,1,1,1,1} };

	char two[8][8] = {  {1,1,1,1,1,1,1,1},
	{1,0,0,0,0,1,0,1},
	{1,1,1,1,0,1,0,1},
	{1,0,0,1,0,1,1,1},
	{1,1,0,0,0,0,0,1},
	{1,1,1,1,0,1,1,1},
	{1,0,0,0,0,1,0,1},
	{1,1,1,1,1,1,1,1} };
	char three[8][8] ={ {1,1,1,1,1,1,1,1},
	{1,0,1,0,0,0,1,1},
	{1,0,1,0,1,0,0,1},
	{1,0,1,0,1,0,1,1},
	{1,0,1,0,1,0,1,1},
	{1,0,1,0,1,0,1,1},
	{1,0,0,0,1,0,0,1},
	{1,1,1,1,1,1,1,1} };
	char four[8][8] = { {1,1,1,1,1,1,1,1},
	{1,0,1,0,1,0,1,1},
	{1,0,1,0,0,0,0,1},
	{1,0,0,0,1,1,1,1},
	{1,1,1,0,1,0,0,1},
	{1,0,0,0,0,0,1,1},
	{1,1,0,1,1,0,0,1},
	{1,1,1,1,1,1,1,1} };


	printEncodedMaze(encodedmaze, wall);
	printEncodedMazeWithPath(encodedmaze,encodedmazepath , wall);
	encode8by8Maze(one, encodedmazeone);
	encode8by8Maze(two, encodedmazetwo);
	encode8by8Maze(three, encodedmazethree);
	encode8by8Maze(four, encodedmazefour);
	printEncodedMaze(encodedmazeone, wall);
	printEncodedMaze(encodedmazetwo, wall);
	printEncodedMaze(encodedmazethree, wall);
	printEncodedMaze(encodedmazefour, wall);

	for (int a = 0; a < 4; a++) {
		for (int b = 0; b < 4; b++) {
			for (int c = 0; c < 4; c++) {
				for (int d = 0; d < 4; d++) {
					merge8by8Mazes(encodedmazearray[a], encodedmazearray[b], encodedmazearray[c], encodedmazearray[d], encoded14maze);
					if (isPathInMaze(encoded14maze, ispathencoded, sizeof(encoded14maze) / sizeof(encoded14maze[0])) == '1') {
						printf("%d,%d,%d,%d\n", a + 1, b + 1, c + 1, d + 1);
						printEncodedMaze(encoded14maze, wall);
					}

					for (int i = 0; i < 14; i++) {
						encoded14maze[i] = 0;
					}
				}
			}
		}
	}
}

void printEncodedMaze(int maze[], unsigned char symbol) {
	printf("MAZE\n");
	int count = 0;
	for (int i = 0; i < 32; i++) {
		if (maze[0] & (1 << i)) {
			count++;
		}
	}
	for (int arraylines = 0; arraylines < count; arraylines++) {
		for (int bitnum = count - 1; bitnum >=0; bitnum--) {
			if (maze[arraylines] & (1 << bitnum)){
				printf("%c",symbol);
			}else {
				printf(" ");
			}
		}
		printf("\n");
	}
}
void printEncodedMazeWithPath(int maze[] ,int mazepath[], unsigned char symbol) {
	printf("\nMAZE WITH PATH\n");
	int count = 0;
	for (int i = 0; i < 32; i++) {
		if (maze[0] & (1 << i)) {
			count++;
		}
	}
	for (int arraylines = 0; arraylines < count; arraylines++) {
		for (int bitnum = count - 1; bitnum >= 0; bitnum--) {
			if (maze[arraylines] & (1 << bitnum)) {
				printf("%c", symbol);
			}
			else if (mazepath[arraylines] & (1 << bitnum)) {
				printf(".");
			}
			else {
				printf(" ");
			}
		}
		printf("\n");
	}
}
void encode8by8Maze(char inputMaze[8][8], int encodedMaze[8]) {
	int temp = 0;
	int bitnum = 7;
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (inputMaze[i][j] == 1) {
				temp = temp | (1 << bitnum);
			}
			bitnum--;
		}
		encodedMaze[i] = temp;
		//printf("%d\n", encodedMaze[i]);
		temp = 0;
		bitnum = 7;
	}
}
void merge8by8Mazes(int topLeft[8], int topRight[8], int bottomLeft[8], int bottomRight[8], int finalMaze[14]) {
	//redo with temp
	//upper
	int templeft = 0;
	int tempright = 0;
	for (int i = 0; i < 7; i++) {
		templeft = topLeft[i] << 6;
		templeft = templeft & ~(1 << 6);
		tempright = topRight[i] & ~(1 << 7);
		finalMaze[i] = templeft + tempright;
	}
	//lower
	templeft = 0;
	tempright = 0;
	int poslow = 7;
	for (int i = 1; i < 8; i++) {
		templeft = bottomLeft[i] << 6;
		templeft = templeft & ~(1 << 6);
		//printf("topl%d\n", bottomLeft[i]);
		tempright = bottomRight[i] & ~(1 << 7);
		//printf("topr%d\n", bottomRight[i]);
		finalMaze[poslow] = templeft + tempright;
		//printf("fin%d\n", finalMaze[poslow]);
		poslow++;
	}

}/////do program to find all combinations of 1,2,3,4, and set those as the parameters


char isPathInMaze(int maze[], int mazepath[], unsigned char dimension) {
	for (int arraylines = 0; arraylines < (int)dimension; arraylines++) {
		for (int bitnum = (int)dimension - 1; bitnum >= 0; bitnum--) {
			if (maze[arraylines] & (1 << bitnum)) {
				if (mazepath[arraylines] & (1 << bitnum)) {
					return '0';
				}
			}
			//if this doesnt get triggered return 1 cus it fits.
		}
	}

	return '1';
}
//11111111111111111111111111111111 -1
//10000000000100000001001000101001 -2146430423
//10111101110101111101011010101011 -1109928277
//10100101000100000100001010001011 -1525661045
//10100000011110111101100111010011 -1602496045
//10101111000000000000111101010111 -1358950569
//10101001011110111011100000000001 -1451509759
//10001101001000101000110111011111 -1927115297
//10100001111011101110000010000001 -1578180479
//10101111001111001010111010111101 -1354977603
//10101000000000011000011010101001 -1476294999
//10000011101111000011001010101011 -2084818261
//10111010101000101001011010000011 -1163749757
//10001010111010101101110000110111 -1964319689
//10110000000010001001010111100101 -1341614619
//10010111101011101111010100000101 -1750141691
//10110101001000100000011111101101 -1256060947
//10100101101010101111010101000001 -1515522751
//10111000001110100101010101011101 -1204136611
//10001011011010111101010100010101 -1955867371
//10111001000010000001010001100101 -1190652827
//10100011011010101111000111101101 -1553272339
//10111110011000101000011100000101 -1100839163
//10001000110010101111110001110101 -1999963019
//11011010010111100001001101011111 -631368865
//10001111110100001101101001000001 -1882138047
//10111010000101100100101011011101 -1172944163
//10101011110100100101001000000101 -1412279803
//10100010100101111101011011110101 -1567107339
//11110110001101000100010010111101 -164346691
//10000000100001010001000110000001 -2138762879
//11111111111111111111111111111111 -1
