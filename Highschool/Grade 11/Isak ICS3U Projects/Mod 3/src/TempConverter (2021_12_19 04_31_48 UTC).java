import java.text.DecimalFormat;
import java.util.Scanner ;
 
public class TempConverter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int F;
		double C;
		
		System.out.print("Please enter Temperature in Farenheit: ");
		F = input.nextInt();
		input.close();
		C = (F-32);
		C= (double)5/9 * C;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Degrees in Celsius is: " + df.format(C));
		
		
		
	}

}
