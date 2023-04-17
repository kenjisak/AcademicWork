#include <stdio.h> 
#include <string.h>
 

int main(){
	 
	char name[100];
	int counter = 0;
	
	printf("Enter a name: ");
	scanf("%s",name);
	
	for(int i = 0; name[i]!= '\0'; i++){
	counter++;
	}
	printf("%d\n",counter);
}

