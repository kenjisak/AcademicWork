import java.util.Scanner;

public class LongDivision {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int num;
	int den;
	System.out.println("Enter the numerator");
	num= input.nextInt();
	System.out.println("Enter the denominator");
	den=input.nextInt();
	input.close();
	System.out.println("----------------");
	System.out.println(num + " divided by " + den + " = " + (num / den) + " with a remainder of " + (num % den));
	System.out.println("or");
	System.out.println(num + " divided by " + den + " = " + (num / (double)den));
	
	}

}
