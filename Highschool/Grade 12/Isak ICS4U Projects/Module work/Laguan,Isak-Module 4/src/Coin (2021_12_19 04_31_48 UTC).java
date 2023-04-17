
public class Coin {
	private int faceUp;
	
	
	public int getshowFace(){
		return(faceUp);
		
	}
	
	public void setflipCoin(){
		faceUp = (int) ((1-0+1)* Math.random() + 0);
	
	}
	
	
	/**
	* Returns a String that represents the Circle object.
	* pre: none
	* post: A String representing the Circle object has been returned.
	*/
	public String toString() {//method returns a string
		String nickelStringup;
		nickelStringup = "Heads up";
		return nickelStringup;
	}
	
	public String toString(int num) {//overloaded method returns a string
		String nickelStringdown;
		nickelStringdown = "Tails up";
		return nickelStringdown;
	}
	
	
	
}
