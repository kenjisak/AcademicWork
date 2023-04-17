/*
* WordGuess.java from Module 5
*
*/
import java.util.Scanner;
/**
* Plays a word guessing game with one player.
*/
public class WordGuess {
public static void main(String[] args) {
	final String SECRET_WORD = "BRAIN";
	final String FLAG = "!";
	String wordSoFar = "", updatedWord = "";
	String letterGuess, wordGuess = "";
	int numGuesses = 0;
	Scanner input = new Scanner(System.in);
	/* begin game */
	//Generate and display a set of dashes that represent the word
	System.out.println("WordGuess game.\n");
	for (int i = 0; i < SECRET_WORD.length(); i++) {
		wordSoFar += "-"; //word as dashes
	}
	System.out.println(wordSoFar + "\n"); //display dashes
	/* allow player to make guesses*/
	do {

		//prompt user for a letter
		System.out.print("Enter a letter(" +FLAG + " to guess entire word): ");
		letterGuess = input.nextLine();
		//convert to all uppercase
		letterGuess = letterGuess.toUpperCase();
		/* increment number of guesses */
		//update guesses counter
		numGuesses += 1;
		/* player correctly guessed a letter--extract string in wordSoFar up to
		 * the letter guessed and then append guessed letter to that string.
		 * Next, extract rest of wordSoFar and append after the guessed letter
		 */
		//determine if a letter is in word
		//if letter is in word
		if (SECRET_WORD.indexOf(letterGuess) >= 0) {
			//create new string that contains the guessed letter
			updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess));
			updatedWord += letterGuess;
			updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess)+1,

			wordSoFar.length());

			wordSoFar = updatedWord;
		}
		/* display guessed letter instead of dash */
		System.out.println(wordSoFar + "\n");
		//while (all letters haven’t been guessed and user hasn’t chosen to guess the entire word)
	} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD));
	/* finish game and display message and number of guesses */
	//if (! Has been entered)
	if (letterGuess.equals(FLAG)) {
		//get a word guess from player
		System.out.println("What is your guess? ");
		wordGuess = input.nextLine();
		//convert word to all uppercase
		wordGuess = wordGuess.toUpperCase();
	}

	//ICS4U Module 3 – Case Study – WordGuess

	//if (word guessed equals secret word OR all the letters have been guessed)
	if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
		//display message that player has won
		System.out.println("You won!");
		//else
		//display message that player has lost
	} else {
		System.out.println("Sorry. You lose.");
	}
	//display secret word
	System.out.println("The secret word is " + SECRET_WORD);
	//display number of guesses
	System.out.println("You made " + numGuesses + " guesses.");
}
}