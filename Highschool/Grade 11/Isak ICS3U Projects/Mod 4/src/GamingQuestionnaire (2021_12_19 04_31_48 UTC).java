import java.util.Scanner;

public class GamingQuestionnaire {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	String gamer;
	String ans;
	boolean exchange = false;
	
	do {
	System.out.println("Are you a PC or Console Gamer?");
	gamer = input.nextLine();
	
	if (gamer.equals("PC") || gamer.equals("PC Gamer")) {
		System.out.println("Do you like being a PC Gamer");
		ans = input.nextLine();
		if (ans.equals("yes") || ans.equals("Yes")) {
			System.out.println("End");
			exchange = false;
		}else{ 
			gamer.equals("Console");
			exchange = true;
		}
	}else if (gamer.equals("Console") || gamer.equals("Console Gamer")){
		System.out.println("Do you like being a Console Gamer");
		ans = input.nextLine();
		if (ans.equals("yes") || ans.equals("Yes")) {
			System.out.println("End");
			exchange = false;
		}else{
			gamer.equals("PC");
			exchange = true;
		}
		input.close();
	}
	}while (exchange == true);
	}
	}

