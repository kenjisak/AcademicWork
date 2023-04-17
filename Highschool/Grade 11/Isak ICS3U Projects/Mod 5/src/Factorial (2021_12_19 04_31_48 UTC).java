import java.util.Scanner;
public class Factorial {

	public static void main(String[] args) {
	int userFactorial = 1;
	int userNum;
	Scanner input=new Scanner(System.in);
	userNum = input.nextInt();
	for (int i = userNum ;i >= 1;i--){
		userFactorial = userFactorial * i;	
	}
	System.out.println(userFactorial);
	input.close();
	}

}
