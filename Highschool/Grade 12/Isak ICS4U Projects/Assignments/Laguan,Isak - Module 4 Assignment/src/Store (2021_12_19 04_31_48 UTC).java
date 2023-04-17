import java.util.Scanner;
public class Store {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner answer = new Scanner(System.in);
		
		Cart cart = new Cart();
		
		String createacc;
		String ans;
		
		String email; 
		String pass;
		String name;
		String user;
		
		String buy;
		Account account;
	
		
		System.out.print("Do you have a Steam Account?: ");
		createacc = input.nextLine();
		
		if (createacc.equals("no")){
			System.out.print("Would you like to make one?: ");
			ans = answer.nextLine();
			if(ans.equals("no")){
				account = new Account();
				System.out.println("\nWelcome " + account.getname());
				System.out.println("You have " + account.getbalance() + " to spend");
			}else{
				System.out.print("Input Email: ");
				email = input.nextLine();
				System.out.print("Input Pass: ");
				pass = input.nextLine();
				System.out.print("Input Name: ");
				name = input.nextLine();
				System.out.print("Input Username: ");
				user = input.nextLine();
				account = new Account(email,name,user,pass);
				System.out.println("\nA new account has been created, here are your credentials: ");
				System.out.println( "Name: " + account.getname() + "\nUser: " + account.getuser() + "\nEmail: " + account.getemail() + "\nPassword: " + account.getpass());
				System.out.println("\nWelcome " + account.getname());
				System.out.println("You have " + account.getbalance() + " to spend");	
			}

		}else if(createacc.equals("yes")){
			System.out.println("\nInput Email: ");
			email = input.nextLine();
			System.out.println("Input Pass: ");
			pass = input.nextLine();
			account = new Account(email,pass);
			if (account.equals(account)== true){
				System.out.println("\nWelcome Back " + account.getname() );
			System.out.println("You have " + account.getbalance() + " to spend");
			
			}
			
		} else {
			account = new Account();
		}
		
		
		System.out.println("\nSteam Store: ");
		System.out.println("What games would you like to buy?: ");
		System.out.println("\nGarry's Mod = " + cart.getgmodcost() + "\nRainbow 6 Siege = " + cart.getr6cost() + "\nArma 3 = " + cart.getarmacost() + "\nRocket League = " + cart.getrlcost() + "\nMetro = " + cart.getmetrocost());
		System.out.println("If you finished, enter *Proceed to Checkout*");
		//while loop, if everything is in cart then stop the loop else if they choose to end then proceed with transaction
		Boolean done = false;
		//cart.getgmodcart()==0||cart.getr6cart()==0||cart.getarma3cart()==0||cart.getrlcart()==0||cart.getmetrocart()==0
		while(done == false){
			buy = input.nextLine();
			if (buy.equals("Garry's Mod")){
				cart.setgmod();
				System.out.println("Garry's Mod has been added");
			}else if (buy.equals("Rainbow 6 Siege")){
				cart.setr6();
				System.out.println("Rainbow 6 Siege has been added");
			}else if (buy.equals("Arma 3")){
				cart.setarma3();
				System.out.println("Arma 3 has been added");
			}else if (buy.equals("Rocket League")){
				cart.setrl();
				System.out.println("Rocket League has been added");
			}else if (buy.equals("Metro")){
				cart.setmetro();
				System.out.println("Metro has been added");
			}else{
				//cart.setgamesoverride();
				done = true;
			}
		}
	
		System.out.println(cart.toString());
		
		if (cart.getmetro()==1){
			System.out.println("Metro");
		}
		if (cart.getgmod()==1){
			System.out.println("Garry's Mod");
		}
		if (cart.getr6()==1){
			System.out.println("Rainbow 6 Siege");
		}
		if (cart.getarma3()==1){
			System.out.println("Arma 3");
		}
		if (cart.getrl()==1){
			System.out.println("Rocket League");
		}
		
		
		
		System.out.println("\nTotal cost is: " + cart.gettotal());
		
		account.setbalance(cart.gettotal());
		
		System.out.println("Your new account balance is " + account.getbalance());
		
		input.close();
		answer.close();
	}

}
