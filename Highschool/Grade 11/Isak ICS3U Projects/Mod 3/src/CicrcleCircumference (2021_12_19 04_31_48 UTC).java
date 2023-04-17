import java.text.DecimalFormat;
import java.util.Scanner;

public class CicrcleCircumference {

	public static void main(String[] args) {
	final double C = 3.14 ;
	double R;
	Scanner input= new Scanner(System.in);
	
	System.out.print("Please enter the radius of your cirlce = ");
	R = input.nextDouble();
	input.close();
	
	
	DecimalFormat df = new DecimalFormat("0.00");
	System.out.println(("Circumference = ")+ df.format(2*C*R));
	}
}
