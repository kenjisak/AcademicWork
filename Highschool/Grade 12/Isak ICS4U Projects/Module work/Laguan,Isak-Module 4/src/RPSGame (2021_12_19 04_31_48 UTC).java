/**
* Models a game of RPS
*/
import java.lang.Math;
public class RPSGame {
	public static final int ROCK = 1, PAPER = 2, SCISSORS = 3;
	private int compThrow;
	private int playerWins = 0, computerWins = 0;
	/**
	* constructor
	* pre: none
	* post: RPSGame object created. Computer throw generated.
	*/
	public RPSGame() {
		compThrow = (int)(3 * Math.random() + 1); //1, 2, or 3
		playerWins = 0;
		computerWins = 0;
	}
	public int getcomputerwins(){
		return computerWins;
	}
	public int getplayerwins(){
		return playerWins;
	}
	/**
	* Computer's throw is generated (ROCK, PAPER, or SCISSORS)
	* pre: none
	* post: Computer's throw has been made.
	*/
	public void makeCompThrow(){
		compThrow = (int)(3 * Math.random() + 1); //1, 2, or 3
	}
	/**
	* Returns the computer's throw.
	* pre: none
	* post: Computer's throw has been returned.
	*/
	public int getCompThrow() {
		return(compThrow);
	}
	/**
	* Determines the winner of the round.
	* pre: playerThrow is the integer 1, 2, or 3.
	* post: Displays a message indicating throws. Compares player's
	* throw to computer's throw and displays a message indicating
	* the winner.
	*/
	public void announceWinner(int playerThrow , String name) {
		/* Inform player of throws */
		System.out.print(name + " throw ");
		
		switch (playerThrow) {
			case ROCK: System.out.println("ROCK."); break;
			case PAPER: System.out.println("PAPER."); break;
			case SCISSORS: System.out.println("SCISSORS."); break;
		}
		
		System.out.print("Computer throws ");
		
		switch (compThrow) {
			case ROCK: System.out.println("ROCK."); break;
			case PAPER: System.out.println("PAPER."); break;
			case SCISSORS: System.out.println("SCISSORS."); break;
		}
		
		/* Determine and annouce winner */
		if (playerThrow == ROCK && compThrow == ROCK) {
			System.out.println("It's a draw!");
		} else if (playerThrow == ROCK && compThrow == PAPER) {
			System.out.println("Computer wins!");
			computerWins += 1;
		} else if (playerThrow == ROCK && compThrow == SCISSORS) {
			System.out.println(name + " wins!");
			playerWins += 1;
		}
		
		
		if (playerThrow == PAPER && compThrow == ROCK) {
			System.out.println(name + " wins!");
			playerWins += 1;
		} else if (playerThrow == PAPER && compThrow == PAPER) {
			System.out.println("It's a draw!");
		} else if (playerThrow == PAPER && compThrow == SCISSORS) {
			System.out.println("Computer wins!");
			computerWins +=1;
		}
		
		
		if (playerThrow == SCISSORS && compThrow == ROCK) {
			System.out.println("Computer wins!");
			computerWins += 1;
		} else if (playerThrow == SCISSORS && compThrow == PAPER) {
			System.out.println(name + " wins!");
			playerWins += 1;
		} else if (playerThrow == SCISSORS && compThrow == SCISSORS) {
			System.out.println("It's a draw!");
		}
		
	}
	/**
	* Displays the overall winner.
	* pre: none
	* post: Computer and player wins compared and
	* an overall winner announced.
	*/
	public void bigWinner(String name) {
		if (computerWins > playerWins){
			System.out.println("Computer wins Rock Paper Scissors!");
		} else if (playerWins > computerWins){
			System.out.println( name + " wins Rock Paper Scissors!");
		} else {
			System.out.println("It's a draw, Game Over!");
		}
	}
}
//modify bigwinner, add string parameter name, change You to the name
//modify announcewinner, add string parameter name, change you to the name
