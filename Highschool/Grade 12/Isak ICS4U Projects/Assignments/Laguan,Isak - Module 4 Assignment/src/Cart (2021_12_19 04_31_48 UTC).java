
public class Cart {
	private double total;
	private int gmod,r6,arma3,rl,metro;
	private static final double gmodcost = 10.99; 
	private static final double r6cost = 29.99;
	private static final double armacost = 54.99;
	private static final double rlcost = 21.99;
	private static final double metrocost = 21.99;
	/**
	* constructor
	* pre: none
	* post: Cart object created. Sets all the games as 0 so that it shows its not in cart.
	*/
	public Cart(){
		total = 0;
		gmod = 0;
		r6 = 0;
		arma3 = 0;
		rl = 0;
		metro = 0;
	}
	
	/**
	* Returns the games' value if whether its in the cart or not.
	* pre: none
	* post: games' value returned.
	*/
	///////////////////////////////////////////////////////////////////////
	public int getgmod(){
		return gmod;
	}
	public int getr6(){
		return r6;
	}
	public int getarma3(){
		return arma3;
	}
	public int getrl(){
		return rl;
	}
	public int getmetro(){
		return metro;
	}
	/**
	* Returns the games' cost value.
	* pre: none
	* post: games' cost value returned.
	*/
	/////////////////////////////////////////////////////////////////////
	public double getgmodcost(){
		return gmodcost;
	}
	
	public double getr6cost(){
		return r6cost;
	}
	
	public double getarmacost(){
		return armacost;
	}
	public double getrlcost(){
		return rlcost;
	}
	public double getmetrocost(){
		return metrocost;
	}
	public double gettotal(){
		return total;
	}
	/**
	* Sets the  games' value to 1 so that its in the cart and adds the cost of game to the total.
	* pre: none.
	* post: games are added to cart and the cost is added to the total.
	*/
	//////////////////////////////////////////////////////////////
	public void setgmod(){
		gmod = 1;
		total = total + gmodcost;
	}
	
	
	public void setr6(){
		r6 = 1;
		total = total + r6cost;
		
	}
	
	public void setarma3(){
		arma3 = 1;
		total = total + armacost;
		
	}
	
	public void setrl(){
		rl = 1;
		total = total + rlcost;
		
	}
	
	public void setmetro(){
		metro = 1;
		total = total + metrocost;
		
	}
	/**
	*
	* Returns a String that states a sentence to start listing items in the cart .
	* pre: none
	* post: The String has been returned.
	*/
	///////////////////////////////////////////////////////
	public String toString(){
		
		String items = "Here are the items that are in your cart: " ;
		return items;
	}
	
	//make a new member variable that holds the games in. make an if statement that if the games are set to 1 then it prints out a line of the game.
	
	
	
}

