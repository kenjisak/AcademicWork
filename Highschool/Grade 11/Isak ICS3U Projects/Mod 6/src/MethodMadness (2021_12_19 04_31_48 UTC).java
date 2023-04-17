/*
 * Method Madness Assignment for Module 6
 * Isak Laguan
 * May 25th, 2018
 * ICS3U
 * This program is meant to display 8 different methods ranging from arrays to nice images made of asterisks.
 */
import java.util.Scanner;
	public class MethodMadness {
	
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
			displayPicture();
			lineBreak(40);
			getFormalName();
			lineBreak(40);
			String word1 = "apple";
			String word2 = "orange";
			System.out.println("Which is first? ("+word1+", or "+ word2+")");
			System.out.println(findFirst(word1,word2));
			lineBreak(40);
			repeatWord("chirp",10);
			lineBreak(40);
			showNumArray();
			lineBreak(40);
			showStringArray(5);
			lineBreak(40);
			randomDice(100);
}
	
	private static String getFormalName() {// asks for first and last name input then displays it
		String first;
		String last;
		System.out.println("Please enter your First Name:");
		first = input.nextLine();
		System.out.println("Please enter your Last Name:");
		last = input.nextLine();
		
		String name ="Your name is: " + first + ", " + last;
		System.out.println(name);
		return name;
		
	}
	private static void lineBreak(int i) {//set of 40 dashes and acts as a separator
		for(i=0;i<40;i++){
			System.out.print("-");
		}
		System.out.print("\n");
	}
	private static void displayPicture() {//displays asterisk picture
	System.out.println("*");
	System.out.println("**");
	System.out.println("***");
	System.out.println("****");
	System.out.println("*****");
	System.out.println("******");
	System.out.println("*******");
	System.out.println("********");
	System.out.println("*********");
	System.out.println("**********");
	
	}
	private static void repeatWord(String string, int i) {// repeats the word and displays it
		for (i=0;i<10;i++){
			System.out.print(string);
		}
		System.out.print("\n");
	}
	public static String findFirst(String word1, String word2) {// chooses which is the first word that comes alphetabetically
	int num=word1.compareTo(word2);

	if (num<0) {
		return(word1);
	}else{
		return(word2);
		
	}
		
	}
	public static void showNumArray() {//sets an array for 10 numbers,user inputs 10 numbers and the numbers gets displayed after
		System.out.println("Please enter 10 numbers, one per line");
		int[] numbers= new int[10];
	
		for (int i=0;i<10;i++){
			numbers[i] = input.nextInt();
			
		}
		for (int i=0;i<10;i++){
			int num = i+1;
			System.out.println("numbers[" + num + "] = " + numbers[i]);
			
		}
		
	}
	public static void showStringArray(int i) {//has an array set to 5 words, user enters 5 words and theyre displayed after
		input.nextLine();
		System.out.println("Please enter 5 words, one per line");
		String[] words= new String[5];
	
		for ( i=0;i<5;i++){
			words[i] = input.nextLine();
			
		}
		for ( i=0;i<5;i++){
			int num = i+1;
			System.out.println("words[" + num + "] = " + words[i]);
			
		}
		
	}
	private static void randomDice(int times) {
int diceCount[] = new int[times];
		
		for(int i = 0; i<100; i++){
		int dice = (int) (6 * Math.random() + 1);
		diceCount[dice]++;	
		}
		for(int i = 1; i <= 6; i++){
			System.out.print("\nTotals ["+i+"] = ");
			System.out.println(diceCount[i]);
			}
		
	}
	
	
	
	
	 
}
