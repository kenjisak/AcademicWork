import java.util.Scanner;
import java.text.DecimalFormat;
public class Diceroll {

	public static void main(String[] args) {
		//initialized variables r1-10,10 random numbers for the dice rolls, booleans for redoing the loops, Strings for the password and incorrect msg
		double r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
		boolean redo= true;
		boolean redopass=true;
		String pass="password";
		String passcheck = " ";
		String incorrect="The password you typed is incorrect.";
		DecimalFormat df = new DecimalFormat("0");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Guess the password");
			
		
		
		//for loop is giving you three tries to guess the password,subtracts 1 try each failed attempt
		for (int i= 3;i>0;i--){
			//if redopass is true the number of tries left is displayed, enter password displayed, passcheck inputline
			if (redopass==true){
				System.out.println("\nNumber of tries: " + i);
				System.out.print("Enter password: ");
				passcheck=input.nextLine();
			}	
			//if if user enters the right password(password) then if passcheck equals pass it sets redopass to false so that the loop would continue but wont display the number of tries because the if statement wont happen,
			//redo is also set to false so it can start the while statement to randomize the dice rolls
			if (passcheck.equals(pass)){
				redopass=false;
				redo=false;
			//else if the pass word inputed is wrong and redopass is still true then incorrect password msg is set to all uppercase and displayed, if i is 1 then the number of tries is all used up and acces denied msg comes up
			}else if (redopass==true){
		
				System.out.println(incorrect.toUpperCase());
				if (i==1){
					System.out.println("Access denied");	
				
				}
			}

		}
	
		
		
		//when the right password is entered and redo is false, all 10 numbers will be randomized 
		while(redo==false){
		System.out.println(" ");
		r1=(6 - 1)*Math.random()+1;
		r2=(6 - 1)*Math.random()+1;
		r3=(6 - 1)*Math.random()+1;
		r4=(6 - 1)*Math.random()+1;
		r5=(6 - 1)*Math.random()+1;
		r6=(6 - 1)*Math.random()+1;
		r7=(6 - 1)*Math.random()+1;
		r8=(6 - 1)*Math.random()+1;
		r9=(6 - 1)*Math.random()+1;
		r10=(6 - 1)*Math.random()+1;
			//do while loop happens and displays the dice rolls and totalsfor each row then sets redo to true so that the do while statement doesnt keep looping continously 
			do {
				System.out.format("%-20s %15s %30s", "Dice 1","Dice 2","Total\n");
				System.out.format("%-20s %15s %30s", df.format(r1),df.format(r2),df.format(r1+r2) + "\n");
				System.out.format("%-20s %15s %30s", df.format(r3),df.format(r4),df.format(r3+r4) + "\n");
				System.out.format("%-20s %15s %30s",df.format(r5),df.format(r6),df.format(r5+r6) + "\n");
				System.out.format("%-20s %15s %30s", df.format(r7),df.format(r8),df.format(r7+r8) + "\n");
				System.out.format("%-20s %15s %30s",df.format(r9),df.format(r10),df.format(r9+r10) + "\n");
			
				redo=true;
			}while(redo==false);{
				//if the answer is yes then reroll the dices again and displays the totals 
				System.out.print("Would you like to roll again?: ");
				passcheck=input.nextLine();
				if (passcheck.equals("yes")){
					redo=false;
				}else{
					redo= true;
				}
				input.close();
			}
		
		
		}
	}


}
