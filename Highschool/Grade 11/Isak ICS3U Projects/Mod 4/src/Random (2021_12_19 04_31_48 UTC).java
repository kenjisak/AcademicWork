import java.text.DecimalFormat;
import java.util.Scanner;

public class Random {

	public static void main(String[] args) {
	int one;
    int two;
    double random;
 
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a minimum desired number: ");
    one=input.nextInt();
    System.out.print("Enter a maximum desired number: ");
    two=input.nextInt();
    input.close();
    
	random=(two - one)*Math.random()+one;
	DecimalFormat df = new DecimalFormat("0");
	
	System.out.println("The Random Number: " + df.format(random));
	}

}
