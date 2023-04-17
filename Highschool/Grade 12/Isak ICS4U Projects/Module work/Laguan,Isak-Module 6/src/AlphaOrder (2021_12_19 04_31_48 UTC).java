import java.util.*;
public class AlphaOrder {
	
	public static void displayArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		
		System.out.println("\n");
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputword = new Scanner(System.in);
		int numofwords;
		String[] word;
		
		System.out.println("Enter number of words");
		numofwords = input.nextInt();
		//input.close();
		
		word = new String[numofwords];
		for (int i = 0; i < word.length; i++){
			System.out.println("Enter a word:");
			word[i] = inputword.nextLine();
		}
		
		System.out.println("Unsorted");
		displayArray(word);
		
		sort.selectionsort(word);
		
		System.out.println("Sorted");
		displayArray(word);
	}

}
