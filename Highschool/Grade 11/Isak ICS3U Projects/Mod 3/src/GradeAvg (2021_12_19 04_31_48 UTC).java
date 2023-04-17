import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeAvg {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	double total = 0;
	double avg;
	System.out.println("Grade Average");
	System.out.print("Please enter 1st grade:");
	total += input.nextDouble();
	System.out.print("Please enter 2nd grade:");
	total += input.nextDouble();
	System.out.print("Please enter 3rd grade:");
	total += input.nextDouble();
    System.out.print("Please enter 4th grade:");
    total += input.nextDouble();
    System.out.print("Please enter 5th grade:");
    total += input.nextDouble();
    input.close(); 
    avg = total / 5;
    DecimalFormat df = new DecimalFormat("0.00");
	System.out.println("Your Final Average is:" + df.format(avg));
	}

}
