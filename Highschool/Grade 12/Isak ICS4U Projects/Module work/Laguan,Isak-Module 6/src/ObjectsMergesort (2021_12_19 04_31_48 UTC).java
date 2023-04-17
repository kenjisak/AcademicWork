import java.util.Scanner;


public class ObjectsMergesort {
	
	public static void displayArray(String[] array){
		
		for (int i = 0; i< array.length; i++){
			System.out.print(array[i] + " " );
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputword = new Scanner(System.in);
		int numItems;
		String[] test;
		System.out.print("Enter number of elements: ");
		numItems = input.nextInt();
		/* populate array with random integers */
		test = new String[numItems];
		for (int i = 0; i < test.length; i++){
			System.out.println("Enter a word:");
			test[i] = inputword.nextLine();
		}
		System.out.println("Unsorted:");
		displayArray(test);
		mergesort.mergesortt(test,0,test.length-1);
		System.out.println("Sorted:");
		displayArray(test);
	}

}
