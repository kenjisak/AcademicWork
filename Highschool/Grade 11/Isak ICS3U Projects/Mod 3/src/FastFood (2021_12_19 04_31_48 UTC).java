import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class FastFood {

	public static void main(String[] args) {
	//declares all needed variables and final prices of food
	final double Burgp= 1.69;
	final double Fryp =1.09;
	final double Sodap=0.99;
	final double Deliv=2.50;
	double burg;
    double fry;
	double soda;
	double total;
	double totalp;
	double tax;
	double pay = 0;
	boolean delivery;
	String order;
	
	
	//displays food menu price
	System.out.println("Burgers = $" + Burgp);
	System.out.println("Fry = $" + Fryp);
	System.out.println("Sodap = $" + Sodap + "\n");
	
	
	//asks for number of food items wanted
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the number of burgers: ");
	burg =input.nextInt();
	System.out.print("Enter the number of fries: ");
	fry= input.nextInt();
	System.out.print("Enter the number of sodas: ");
	soda=input.nextInt();
	input.nextLine(); //clear buffer
	
	//calculations for prices of food ordered
	burg = burg * Burgp;
	fry = fry * Fryp;
	soda = soda * Sodap;
	
	
	//calculations needed for tax and grand total then displays them
	DecimalFormat df = new DecimalFormat("0.00");
	System.out.println("Total before tax: $" + df.format(total = burg + fry + soda));
	System.out.println("Tax: $"+ df.format(tax= total * 0.13));
	totalp = total + tax;
	System.out.println("Grand Total: $"+ df.format(totalp));
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	
	//asks for method of food travel
	System.out.println("Delivery or Take out? ");
	order = input.nextLine();
	if(order.equals("delivery") || order.equals("Delivery")) {
		delivery = true;
	}else{
		delivery = false;
	}
	
	
	
	//if delivery is requested then delivery fee is applied and adds on to a new total
	if (delivery == true){	
	System.out.println("Delivery fee:" + Deliv);
	System.out.println("New Grand Total: " + df.format(totalp= totalp + Deliv));
	}else{
	
	}
	
	

	//asks for money to be paid then displays change
	do {
			System.out.print ("\nEnter amount tendered: $");
			pay = input.nextDouble();
	//if statements for the scenario if delivery is required, then calculations are made		
		if (pay>= totalp && (delivery = true)){
		
			System.out.println("Amount entered: " + money.format(pay));
			System.out.println ("Change: $"+ df.format(pay-totalp));
			input.close();
			
		}else if (pay>=totalp && (delivery = false)){
			System.out.println("Amount entered: " + money.format(pay));
			System.out.println ("Change: $"+ df.format(pay-totalp));
			input.close();
		}else{
	//if there's not enough money paid then it displays a msg and starts the do while statement again and keeps asking for a sufficient payment till it gets one 
			System.out.println("Insufficient funds");   
		}
	}while (pay<totalp);
	}
}

