import java.util.Scanner;


public class Integers {
	public static String pattern(int num1,int num2,int num3){
		String inc = "increasing";
		String dec = "decreasing";
		String ran = "random";
		String eq = "equal";
		
		if (num1 < num2 && num2 < num3){
			return inc;
		} else if  (num1 > num2 && num2 > num3 ){
			return dec;
		} else if (num1==num2 && num2==num3 && num3==num1){
			return eq;
		} else {
			return ran;
		}
		
	
	}
	
	public static void main(String[] args) {
		int num1;
		int num2;
		int num3;
		Boolean loop = true ;
		
			Scanner input = new Scanner(System.in);
	
		do{
			System.out.print("Please input the first number: ");
			
			while (!input.hasNextInt()){
				 System.out.println("Unexpected entry. Must be an integer");
				input.next();				
			 }
			num1 = input.nextInt();
			
			System.out.print("Please input the second number: ");
			

			while (!input.hasNextInt()	){
				 System.out.println("Unexpected entry. Must be an integer");
				input.next();				
			 }
			num2 = input.nextInt();
			System.out.print("Please input the third number: ");
			

			while (!input.hasNextInt()	){
				 System.out.println("Unexpected entry. Must be an integer");
				input.next();				
			 }
			num3 = input.nextInt();
			String result=pattern(num1,num2,num3);
			if (num1<0 || num2<0 || num3<0){
				loop=false;
				System.out.println("You entered the numbers " + num1 + ", " + num2 + " and " + num3 + " they are in " + result + " order");
				input.close();
			}else{ 
				loop= true;
				System.out.println("You entered the numbers " + num1 + ", " + num2 + " and " + num3 + " they are in " + result + " order");
			}
			
		}while(loop);
		
			
		
		
		
		
	}
	

}
 