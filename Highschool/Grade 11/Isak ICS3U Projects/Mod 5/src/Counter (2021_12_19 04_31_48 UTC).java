import java.util.Scanner;
import java.text.DecimalFormat;

public class Counter {

	public static void main(String[] args) {
	int value;
	double sum = 0;
	int loop = 0;
	boolean redo = true;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	
	while(redo){
  
		System.out.print("Enter a value (0 to quit) : ");
		value = input.nextInt();
		sum += value;
		loop ++;
		if (value == 0 && loop > 1){
			loop--;
		    sum = sum / loop;
		    redo = false;
		    System.out.println("Average is " + df.format(sum));
		}else if(value == 0 && loop == 1){
			System.out.println("Average is 0");
			redo = false;
		}
		
	
	}
	input.close();
  }

}
