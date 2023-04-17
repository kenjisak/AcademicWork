import java.util.Scanner;
public class FormalGreeting {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	String user;
	String mr="Mr.";
	String maam="Ms.";
	String maam2="Mrs.";
	String maam3="Miss";
	
	user = input.nextLine();
	if (user.startsWith(mr)){
		System.out.println("Hello, sir.");
	}else if (user.startsWith(maam)||user.startsWith(maam2)||user.startsWith(maam3)){
		System.out.println("Hello, ma'am.");
	}else{
		System.out.println("Hello, " + user);
		
	}
	input.close();
	}

}
