/*
 * Module 5 – Assignment A – SeatingPlan
 * Assignment Name: Seating Plan
 * Name: Kenji Isak Laguan
 * Date: April , 2019
 * Course: ICS4U
 * This program is to allow users to create a seating plan with however many seats they have in their class
 * organized in rows and columns.
 */
import java.util.Scanner;

public class SeatingPlan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner names = new Scanner(System.in);
		Scanner response = new Scanner(System.in);
		String name;
		int numofstudents = 0;
		
		//prompts user for how many rows and columns they want to have in their class
		System.out.print("How many rows of seating does your class have? ");
		int rows = input.nextInt();
		System.out.print("How many columns of seating does your class have? ");
		int columns = input.nextInt();
		//creates new seating plan and displays it
		myClass period1 = new myClass(rows,columns);
		
		boolean done = false;
		boolean check = false;
		
		do{
		//prompts user for a name to put into the seating plan
		System.out.print("Who do you want to add to the seating plan? Enter Q to quit: ");	
		name = names.nextLine();
		//if user enters Q then editing the seating plan was done
		if (name.equals("Q")){
			done = true;
		}else{
			do{
				//prompts user for the row and column they want to put the student in 
				System.out.print("Which row do you want " + name + " to sit in? ");
				int rowsit = input.nextInt();
				System.out.print("Which column do you want " + name + " to sit in? ");
				int columnsit = input.nextInt();
				//if the seat theyre trying to put into is occupied then redos the loop and prompts them for another spot to put the student in
				if(period1.studentcheck(rowsit,columnsit) == true){
					period1.addstudent(name,rowsit,columnsit);
					check = true;
				}else if(period1.studentcheck(rowsit,columnsit) == false ){
					System.out.println("This seat is already taken.");
					check = false;
				}
				
			}while(check == false);
			
		}
			//adds the number of total students each time the user is finished with seating a student
			numofstudents = numofstudents + 1;
		}while(done == false);
		//displays the seating plan after the user is finished editing the seating plan
		period1.displayseatingplan();
		//displays number of students in seating plan
		System.out.println("There are " + (numofstudents - 1) + " number of students in the seating plan.");
		Scanner rowcol = new Scanner(System.in);
		//prompts user if they want to print a single row or column if not program ends. 
		System.out.print("Do you want to print a single row or column?: ");
		String answer = response.nextLine();
		if (answer.equals("row")){
			//prints a single row
			System.out.print("Which row?: ");
			int rowgiven = rowcol.nextInt();
			period1.displayrow(rowgiven-1);
		}else if(answer.equals("no")){
			
		}else{
			//prints a single column
			System.out.print("Which column?: ");
			int colgiven = rowcol.nextInt();
			period1.displaycol(colgiven-1);
		
			
		}
		//closes all scanner inputs
		rowcol.close();
		input.close();
		names.close();
		response.close();
		
	}

}