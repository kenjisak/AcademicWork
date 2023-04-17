
public class DrawLine {
	/**
	* Print a vertical line of asterisks on the screen
	* pre: length > 0
	* post: Line drawn of length characters
	*/
	public static void drawLine(int length){
		for(int i = 1; i <= length ; i++){
			System.out.println("*");
			
		}
	}
	/**
	* Print a vertical line of O's on the screen
	* pre: length > 0
	* post: Line drawn of length characters
	*/
	public static void drawLine(int length, String mark){
		for(int i = 1; i <= length ; i++){
			System.out.println(mark);
			
		}
	}
	/**
	* Displays the equation of addition and the sum of of two values
	* pre: length>0, sum>0 , num>0
	* post: Equation and sum printed on screen
	*/
	public static void drawLine(int length, int num){
		int sum = length + num;
		System.out.println(length + " + " + num + " = " + sum);
	
	}
	/**
	* Displays "LoL" on the screen repeatedly on a different line
	* pre: length > 0
	* post: "LoL" displayed of length characters
	*/
	public static void drawLine(String mark, int length){
		for(int i = 1; i <= length ; i++){
			System.out.println(mark);
			
		}
	}

	public static void main(String[] args) {
		drawLine(10);
		System.out.println(" ");
		drawLine(5,"O");
		System.out.println(" ");
		drawLine(6,6);
		System.out.println(" ");
		drawLine("LoL",7);
		
	}

}
