import java.util.Scanner;
public class NumbersSum {

	public static void main(String[] args) {
	Scanner input= new Scanner(System.in);
	int i=1;
	int num;
	System.out.println("Please enter any whole number: ");
	num = input.nextInt();
	while (i<=num){
		System.out.println(i++);
	}
	input.close();
	}

}
