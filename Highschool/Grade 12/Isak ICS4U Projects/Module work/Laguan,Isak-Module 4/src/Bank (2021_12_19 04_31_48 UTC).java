import java.util.Scanner;
import java.text.NumberFormat;
public class Bank {
	public static void main(String[] args) {
		Account IsakAccount = new Account(1000, "Kenji", "Isak", "1800 Baseline", "Ottawa", "Ontario", "K2C3N1");
		Scanner input = new Scanner(System.in);
		double data;
		String street,state,zip,city;
		String check;
		
		NumberFormat money = NumberFormat.getCurrencyInstance();
		System.out.println(IsakAccount);
		System.out.print("Enter deposit amount: ");
		data = input.nextDouble();
		IsakAccount.deposit(data);
		System.out.println("Balance is: " + money.format(IsakAccount.getBalance()));
		
		System.out.print("Enter withdrawal amount: ");
		data = input.nextDouble();
		IsakAccount.withdrawal(data);
		System.out.println("Balance is: " +
		money.format(IsakAccount.getBalance()));
		input.nextLine();
		System.out.println("Have you moved the past year?");
		check = input.nextLine();
		
		if (check.equals("yes")){
			System.out.print("Please enter your street address: ");
			street = input.nextLine();
			System.out.print("Please enter the current city you live in: ");
			city = input.nextLine();
			System.out.print("Please enter the province you live in: ");
			state = input.nextLine();
			System.out.print("Please enter your zip code: ");
			zip = input.nextLine();
			IsakAccount.changeaddress(street, city, state, zip);
			System.out.println(IsakAccount);
			System.out.print("Transaction is finished.");
			input.close();
		}else{
			System.out.print("Transaction is finished.");
		}
		
	}
}