import java.util.Scanner;

public class Digits {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int one;
	
	System.out.print("Please enter 2 digit number: ");
	one = input.nextInt();
	input.close();
	int onesDigit = one % 10;
	
	int tensDigit = one / 10;
	
	
	System.out.print("Ones Digit is: ");
	System.out.print(onesDigit);
	System.out.print("\nTens Digit is: ");
	System.out.print(tensDigit);
	
	

	}

}
