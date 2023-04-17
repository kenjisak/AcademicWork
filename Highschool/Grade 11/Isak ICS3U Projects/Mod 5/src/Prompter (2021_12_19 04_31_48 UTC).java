import java.util.Scanner;
public class Prompter {

	public static void main(String[] args) {
	
	Scanner input=new Scanner(System.in);
	
	int one;
	int two;
	int three;
	boolean restart = true;
		
	System.out.print("Please enter the minimum number: ");
	one = input.nextInt();
	System.out.print("Please enter the max number: ");
	two = input.nextInt();
	
	while(restart) {
	System.out.print("Please enter a number between "+ one + " & " + two + ": ");
	three = input.nextInt();
	 if (three >= one && three <= two){
		 restart = false;
	 }
	
	}
	
	System.out.println("Fin");
	input.close();
	}

}
