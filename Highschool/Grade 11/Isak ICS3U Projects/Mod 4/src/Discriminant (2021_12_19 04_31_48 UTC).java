import java.util.Scanner;
public class Discriminant {

	public static void main(String[] args) {
	int a;
    int b;
    int c;
    int discriminant;

		
	Scanner input = new Scanner(System.in);
	System.out.println("b^2 - 4ac");
	
	System.out.print("Enter the value for a:");
	a=input.nextInt();
	System.out.print("Enter the value for b: ");
	b=input.nextInt();
	System.out.print("Enter the value for c: ");
	c=input.nextInt();
	input.close();
	
	discriminant = (b*b - 4*a*c);
	
	if  (discriminant<0){
		System.out.println("No roots");
	}else if(discriminant==0){
		System.out.println("One roots");
	}else if(discriminant>0){
		System.out.println("Two roots");
	}
	}
}
