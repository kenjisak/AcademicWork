
public class Rectangle {
	private int length;
	private int width;
	
	
	public Rectangle() {
		length = 2;
		width = 1;
		
	}
	
	public Rectangle(int lengthover, int widthover) {
		length = lengthover;
		width = widthover;
	}
	
	
	public int area() {
		int rectanglearea = length * width;
		return(rectanglearea);
	}
	
	public int perimeter() {
		int rectangleperimeter = 2 * length + 2 * width;
		return(rectangleperimeter);
	}
	
	public void setlength(int newlength) {
		length = newlength;
	}
	
	public void setwidth(int newwidth) {
		width = newwidth;
	}
	
	public int getlength() {
		return length;
		
	}
	
	public int getwidth() {
		return width;
		
	}
	public static void displayAreaFormula() {
		System.out.println("The formula for the area of a rectangle is a = l*w");
	}
	
	public boolean equals(Object r) {//overriding the default equals statement as an overloaded method 
		Rectangle testObj =(Rectangle) r;//turning object c into a circle
		if (testObj.getlength() == length && testObj.getwidth() == width) {
			return(true);
		} else {
			return(false);
		}
	}
	/**
	* Returns a String that represents the Circle object.
	* pre: none
	* post: A String representing the Circle object has been returned.
	*/
	public String toString() {//method returns a string
		String rectString;
		rectString = "The Rectangle has a side length of " + length + " and a width length of " + width;
		return(rectString);
	}
}
