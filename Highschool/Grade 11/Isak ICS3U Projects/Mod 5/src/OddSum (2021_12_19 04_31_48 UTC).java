import java.util.Scanner;
public class OddSum {

	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int usernum;
 
	usernum=input.nextInt();
	int sum=0;
	for (int i =1; i<=usernum;i+=2){
		System.out.println(i);
		sum =sum +i;
	}
	System.out.println("Sum is " + sum);
	input.close();
	}

}

