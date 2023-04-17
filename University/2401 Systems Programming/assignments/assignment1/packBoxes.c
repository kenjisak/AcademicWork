#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main() {
	int randomnumlarge, randomnummedium, randomnumsmall;
	int maxnumofpackages = 24;
	int maxnumofboxes = 6;
	double largeprice = 19.99, mediumprice = 10.99, smallprice = 5.99, tax = 0.13, shipping = 1.49, total;
	char *box[maxnumofboxes][5][4];
	
	//fills in all the boxes with 0s to check if a position is empty later
	for (int boxnum = 0; boxnum < maxnumofboxes; boxnum++){
		for (int row = 0; row < 5; row++){
			for (int col = 0; col < 4; col++){
				box[boxnum][row][col] = "0";
			}
		}
	}
	//creates randomnumber between 0-24 for large, then random number between 0-(24 -large boxes number) for medium and 24 -large boxes number + medium box to give the remaining number to be small packages
	srand(time(NULL));
	randomnumlarge = (int)(((double)rand() / (RAND_MAX)) * maxnumofpackages);
	randomnummedium = (int)(((double)rand() / (RAND_MAX)) * (maxnumofpackages - randomnumlarge));
	randomnumsmall = maxnumofpackages - (randomnumlarge + randomnummedium);
////////////////////////////////////////////////////////////filling in large packages
	int counter = 0;
	int boxcounter = 0;
	for (int boxnum = 0; boxnum < maxnumofboxes; boxnum++){
		if (boxcounter == randomnumlarge){
			break;//stop adding large packages in general if it added all large packages
		}
		for (int row = 0; row < 5; row++){
			if (boxcounter == randomnumlarge){
				break;//stop adding large packages in general if it added all large packages
			}
			if (counter == 4){
				counter = 0;
				break;//stop adding large packages to 1 box
			}
			for (int col = 0; col < 4; col++){
				if (strcmp(box[boxnum][row][col],"0")== 0){
					if(strcmp(box[boxnum][row][col+1], "0")== 0 && strcmp(box[boxnum][row+1][col],"0")== 0 && strcmp(box[boxnum][row+1][col+1],"0")== 0){//if surrounding pixels are empty then add a large box
						if (boxcounter == randomnumlarge){
							break;//stop adding large packages in general  if it added all large packages
						}
						if (counter == 4){
							counter = 0;
							break;//stop adding large packages to 1 box
						}
						box[boxnum][row][col] = "L";
						box[boxnum][row][col+1] = "L";
						box[boxnum][row+1][col] = "L";
						box[boxnum][row+1][col+1] = "L";
						counter++;
						boxcounter++;
					}
				}
			}
		}
	}
///////////////////////////////////////////////////////////////////// fill boxes with mediums
	int boxcountermedium = 0; 
	for (int boxnum = 0; boxnum < maxnumofboxes; boxnum++){
		if (boxcountermedium == randomnummedium){
			break;//stop adding medium packages in general
		}
		for (int row = 0; row < 5; row++){
			if (boxcountermedium == randomnummedium){
				break;//stop adding medium packages in general
			}
			for (int col = 0; col < 4; col++){		
				if (strcmp(box[boxnum][row][col],"0")== 0){
					if(strcmp(box[boxnum][row][col+1], "0")== 0){//if right pixel is empty then add a medium box horizontally
						if (boxcountermedium == randomnummedium){
							break;//stop adding medium packages in general if it added all medium packages
						}
						box[boxnum][row][col] = "M";
						box[boxnum][row][col+1] = "M";
						boxcountermedium++;						
					}else if(strcmp(box[boxnum][row+1][col], "0")== 0){//if right pixel is empty then add a medium box vertically
						if (boxcountermedium == randomnummedium){
							break;//stop adding medium packages if it added all medium packages
						}
						box[boxnum][row][col] = "M";
						box[boxnum][row+1][col] = "M";
						boxcountermedium++;	
					}
				}
			}
		}
	}
////////////////////////////////////////////////////////////////////fill boxes with smalls
	int boxcountersmall = 0; 
	for (int boxnum = 0; boxnum < maxnumofboxes; boxnum++){
		if (boxcountersmall == randomnumsmall){
			break;//stop adding small packages in general if it added all small packages
		}
		for (int row = 0; row < 5; row++){
			if (boxcountersmall == randomnumsmall){
				break;//stop adding small packages in general if it added all small packages
			}
			for (int col = 0; col < 4; col++){
				if (strcmp(box[boxnum][row][col],"0")== 0){//if pixel is empty then add a small package
					if (boxcountersmall == randomnumsmall){
						break;//stop adding small packages in general if it added all small packages
					}
					box[boxnum][row][col] = "S";
					boxcountersmall++;
				}
			}
		}
	}
//////////////////////////////////////////////////////////////////nested for loop, check if first box has any value other than 0, if it does then add it to a counter then break and check the next box, counting how many boxes are filled
	int boxcounterfilled = 0; 
	int true = 0;
	for (int boxnum = 0; boxnum < maxnumofboxes; boxnum++){
		for (int row = 0; row < 5; row++){
			if (true == 1){
				true = 0;
				break;
			}
			for (int col = 0; col < 4; col++){
				if (strcmp(box[boxnum][row][col],"0")!= 0){
					boxcounterfilled++;
					true = 1;
					break;
				}
			}
		}
	}
////////////////////////////////////////////////////////////////////formatting and calculating prices
	
	double taxed = (smallprice *randomnumsmall + mediumprice *randomnummedium + largeprice *randomnumlarge )* tax;
	
	total = smallprice *randomnumsmall + mediumprice *randomnummedium + largeprice *randomnumlarge;
	
	printf("\nOrder: Large = %d, Medium = %d, Small = %d\n\n",randomnumlarge,randomnummedium,randomnumsmall);
	printf("%-6s (%02d units) %10s %6.2lf\n","Small" ,randomnumsmall, "$",smallprice *randomnumsmall );
	printf("%-6s (%02d units) %10s %6.2lf\n","Medium" ,randomnummedium, "$",mediumprice *randomnummedium );
	printf("%-6s (%02d units) %10s %6.2lf\n","Large" ,randomnumlarge, "$",largeprice *randomnumlarge );
	for(int i = 0;i < 40; i++){
		printf("-");
	}
	printf("\n%-8s %19s %6.2lf\n","Total","$",total);
	printf("%-8s (%d boxes) %9s %6.2lf\n","Shipping",boxcounterfilled,"$",boxcounterfilled * shipping);
	printf("%-8s %18s %6.2lf\n","HST (13%)","$",taxed);
	for(int i = 0;i < 40; i++){
		printf("-");
	}
	printf("\n%-8s %13s %6.2lf\n\n","Amount Charged","$", taxed + total + boxcounterfilled * shipping );
	printf("Individual boxes are packed as follows:\n\n");

////////////////////////////////////////////////////////////////////print box contents
	for (int boxnum = 0; boxnum < boxcounterfilled; boxnum++){
		for (int row = 0; row < 5; row++){
			for (int col = 0; col < 4; col++){
				if (strcmp(box[boxnum][row][col],"0") == 0){
					printf("%s"," ");	
				}else{
					printf("%s",box[boxnum][row][col]);
				}
			}
			printf("\n");
		}
		printf("\n");
	}
//////////////////////////////////////////////////////////////////
}

//pseudocode
//fill in first box with large packages, if theres 4 boxes in then fill the rest with either 2 mediums or 4 smalls
//if first box is full of large packages and theres still leftover larges, fill the next box in the array, if theres less than 4 large packages in the 2nd one then fill it with mediums and smalls do it all horizontally continue till no boxes left
//have helper function where it finds closest empty space
//have a condition where it finds the closest empty space then checks the pixels to the right col +1,below row + 1, and left below row + 1 col + 1 if all conditions are true then fill in with L
//have a condition where it finds closest empty space then checks pixel to the right col+1 if empty or if below row +1 is empty then fill in with M
//last condition to find closest empty pixel and fill in with S
// if first empty pixel is checked then check for others
