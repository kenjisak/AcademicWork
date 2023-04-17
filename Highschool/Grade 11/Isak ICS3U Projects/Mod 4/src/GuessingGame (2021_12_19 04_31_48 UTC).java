import java.text.DecimalFormat;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		String randomnum;// strings for when i convert the random and player number to words
		String playernum;
		String response;// response of player when asked to play again
		boolean replay = false;
		double random;
		int player;
		
		Scanner input = new Scanner(System.in);
		
		do {//loop the game
			
		random = (20)*Math.random()+ 1;//random number equation
	 
		System.out.print("Enter a number between 1 and 20: ");
	    player=input.nextInt();
	    input.nextLine();// output msg to start guessing, also has a buffer line so that it can ask a word input for later
	    
	    
	    DecimalFormat df = new DecimalFormat("0");// decimal format to get rid of the decimals in random number
	    randomnum =  df.format(random);// converts double random to a string
	    playernum = df.format(player); // converts integer of player input to string
	    
	    System.out.println("Computers Number: " + randomnum);// displays random number and players number
	    System.out.println("Player's Number: " + playernum);
	    
	    if (playernum.equals(randomnum)){// if string player num equals string random number then display you won msg else you lost
	    	System.out.println("You won!");
	    }else{
	    	System.out.println("Better luck next time.");
	    }
		
	   System.out.println("Do you want to play again?: ");
	   response=input.nextLine();
	   
	   if (response.equals("yes") || response.equals("Yes")){// if response is yes then replay is set to true for the loop statement if player wants to play again
		   replay = true;
	   }else{
		   replay = false;
		  System.out.println("Mama raised a Quitter");//else you quit msg displays,loop is broken, and input is closed
		  input.close();
	  }

		}while(replay == true);// if the replay is set to true then replay the guessing game
		
	}

	
}
