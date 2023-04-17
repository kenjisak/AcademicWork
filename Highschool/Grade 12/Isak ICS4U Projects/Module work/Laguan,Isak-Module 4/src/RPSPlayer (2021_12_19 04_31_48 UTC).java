/**
* models the player in a game of RPS
*/
public class RPSPlayer {
	private int playerThrow;
	private String playerName;
	//ROCK = 1, PAPER = 2, SCISSORS = 3
	/**
	* constructor
	* pre: none
	* post: RPSPlayer object created. The player is given a default throw.
	*/
	public RPSPlayer() {
		playerThrow = 1; //default throw
	}
	/**
	* Sets the player's throw.
	* pre: newThrow is the integer 1, 2, or 3.
	* post: Player's throw has been made.
	*/
	public void makeThrow(int newThrow){
		playerThrow = newThrow;
	}
	/**
	* Sets the player's throw.
	* pre: newThrow is the integer 1, 2, or 3.
	* post: Player's throw has been made.
	*/
	public void assignName(String newname){
		playerName = newname;
	}
	/**
	* Returns the player's throw.
	* pre: none
	* post: Player's throw has been returned.
	*/
	public int getThrow() {
		return(playerThrow);
	}
	/**
	* Returns the player's throw.
	* pre: none
	* post: Player's throw has been returned.
	*/
	public String getName() {
		return(playerName);
	}
}
//member variable playername
//modifier method assignname
//accessor method getname
