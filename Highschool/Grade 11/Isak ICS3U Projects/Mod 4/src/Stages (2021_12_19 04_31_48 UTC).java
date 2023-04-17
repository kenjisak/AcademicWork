import java.util.Scanner;

public class Stages {

	public static void main(String[] args) {
	int age;
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter Age:");
	age=input.nextInt();
	input.close();
	if (age>18){
		System.out.println("Adult");
	}else if (age<=5){
		System.out.println("Toddler");
	}else if(age>5 && age<=10){
		System.out.println("Child");
	}else if(age<=12 && age>10){
		System.out.println("Preteen");
	}else if(age>12 && age<=18){
		System.out.println("Teen");
	
	}

	}

}
