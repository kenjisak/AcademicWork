/*
* RPS2.java from Module 3 (ICS4U)
*/
import java.util.Scanner;
/**
* Computer plays Rock Paper Scissors against one player.
*/
public class RPS2 {
	public static void main(String[] args) {
		RPSGame rps = new RPSGame();
		RPSPlayer rpsOpponent = new RPSPlayer();
		
		int rounds;
		int playerThrow;
		String name;
		Scanner input = new Scanner(System.in);
		Scanner nameinput = new Scanner(System.in);
		/* play RPS */
		System.out.print("Enter your name: ");
		name = nameinput.nextLine();
		System.out.print("How many rounds? ");
		rounds = input.nextInt();
		
		rpsOpponent.assignName(name);
		
		for (int i = 0; i < rounds; i++) {
			System.out.print("Enter your throw (ROCK=1, PAPER=2,SCISSORS=3): ");
			
			playerThrow = input.nextInt();
			rpsOpponent.makeThrow(playerThrow);
			rps.makeCompThrow();
			rps.announceWinner(rpsOpponent.getThrow(), rpsOpponent.getName());
			System.out.println("");
		}
		System.out.println("Computer wins " + rps.getcomputerwins() + " " + rpsOpponent.getName() + " wins " + rps.getplayerwins());
		rps.bigWinner(rpsOpponent.getName());
		input.close();
		nameinput.close();
	}
}
