/*
* TestCoin.java
* Coin--part 1 of 2
*
*/
/**
* The Coin class is tested.
*/
public class TestCoin {
	public static void main(String[] args) {
		Coin nickel = new Coin();
		
		nickel.setflipCoin();
		if (nickel.getshowFace() == 0) {
			//System.out.println("Heads up!");
			System.out.println(nickel.toString());
			
		} else if( nickel.getshowFace()==1) {
			//System.out.println("Tails up!");
			System.out.println(nickel.toString(0));
		}
		

	}

	
}