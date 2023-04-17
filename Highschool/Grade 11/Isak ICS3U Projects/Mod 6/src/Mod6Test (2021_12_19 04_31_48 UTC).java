import java.util.Scanner;
public class Mod6Test {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int grades;
		int sum=0;
		System.out.print("How many scores?: ");
		grades=input.nextInt();
		System.out.println("Enter them: ");
		int[] grade= new int[grades];
		for (int i = 0;i < grade.length; i++){
			
			grade[i]=input.nextInt();
		}
		System.out.print("The scores are: ");
		for (int i = 0;i < grade.length; i++){
			
			System.out.print(grade[i] + ",");
			sum = sum + grade[i];
			
		}
		System.out.println("\nThe average score is " + (sum/grade.length) );
		input.close();
	}

}
