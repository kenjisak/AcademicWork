//import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Rectangle rect2 = new Rectangle(2,1);
	
		
		System.out.println("The Length and Width of the first rectangle is: " + rect.getlength() + " and " + rect.getwidth());
		System.out.println("The Perimeter of the first rectangle is: " + rect.perimeter());
		System.out.println("The Area of the first rectangle is: " + rect.area());
		System.out.println("");
		System.out.println("The Length and Width of the second rectangle is: " + rect2.getlength() + " and " + rect2.getwidth());
		System.out.println("The Perimeter of the second rectangle is: " + rect2.perimeter());
		System.out.println("The Area of the second rectangle is: " + rect2.area());
		System.out.println("");
		Rectangle.displayAreaFormula();
		
		
		if (rect.equals(rect2) == true) {
			System.out.println(rect.equals(rect2));
		}
		System.out.println(rect.toString());
		
	/** new rectangle that user can input and set width and length
	 * 	Rectangle rect3 = new Rectangle();
		int length;
		int width;
		Scanner input = new Scanner(System.in);
	  	System.out.print("Please Enter the Length of your Rectangle: ");
		String emptycheck = input.nextLine();
		System.out.print("Please Enter the Width of your Rectangle: ");
		String emptycheck2 = input.nextLine();
	
	
		if (emptycheck.equals("")) {
			System.out.println(rect.getlength());
		}else{
			length = Integer.parseInt(emptycheck);
			rect.setlength(length);
			System.out.println(rect.getlength());
		}
	
		if (emptycheck2.equals("")) {
			System.out.println(rect.getwidth());
		}else{
			width = Integer.parseInt(emptycheck2);
			rect.setwidth(width);
			System.out.println(rect.getwidth());
		}
	*/	
		
	}

}
