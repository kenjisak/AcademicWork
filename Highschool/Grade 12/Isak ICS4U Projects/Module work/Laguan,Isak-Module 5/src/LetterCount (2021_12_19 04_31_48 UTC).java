/*
* CountLetters.java from Module 5
* Count the occurences of letters in a string.
*/
/**
* The occurences of letters in a string are counted.
*/
import java.util.Scanner;
public class LetterCount {
	public static void main(String[] args) {
		final int LOW = 'A'; //smallest possible value
		final int HIGH = 'Z'; //highest possible value
		int[] letterCounts = new int[HIGH - LOW + 1];
		
		Scanner input = new Scanner(System.in);
		String word;
		
		System.out.print("Enter a word: ");
		word = input.nextLine();
		/* convert word to char array and count letter occurrences */
		word = word.toUpperCase();
		//turns to upper case
		
		
		char[] wordLetters;
		int offset; //array index
		
		/* prompt user for a word */
	
		wordLetters = word.toCharArray();
		
		for (int letter = 0; letter < wordLetters.length; letter++) {
			//check to see if wordLetters[letter] is in the correct range
			int letternumberinascii = wordLetters[letter];
			//System.out.println(letternumberinascii);
			if (letternumberinascii<HIGH && letternumberinascii>LOW ){
				offset = wordLetters[letter] - LOW;
				letterCounts[offset] += 1;
			}else{
				
			}
			
		}
		
		/* show letter occurrences */
		for (int i = LOW; i <= HIGH; i++) {
			System.out.println((char)i + ": " + letterCounts[i -LOW]);
		}
		System.out.println(word.length());
		input.close();
	}
}