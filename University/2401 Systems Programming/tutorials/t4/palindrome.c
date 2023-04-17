#include<stdio.h>
#include<string.h>

// This is a forward reference
int palindrome(char *s);


int main() {

  char word[30];
  
    
  printf ("Enter a word or \"q\" to stop: ");
  scanf ("%s", word);
  
  
  while (strcmp(word, "q") != 0) {
    palindrome(word);
    printf ("\nEnter a word or \"q\" to stop: ");
    scanf ("%s", word);
  };

  return 0;

}
  

int palindrome(char *s){
  char word[30];
  int counter = 0;
  int othercounter = -1;
  strcpy(word,s);
  
   for(int i = 0; word[i]!= '\0'; i++){
	counter++;
	//printf("%d",counter);
   }
  	
   for (int i = counter; i >=0 ; i--) {
   	word[othercounter++] = s[i];
   	//printf("%c",word[i]);
   }
   
  if (strcmp(word,s) == 0 ){
  	printf("\t\"%s\" is a palindrome",s);
  }else{
  	printf("\t\"%s\" is not a palindrome", s);
  }
  // add code to test for palindrome and print a message  
	
}
