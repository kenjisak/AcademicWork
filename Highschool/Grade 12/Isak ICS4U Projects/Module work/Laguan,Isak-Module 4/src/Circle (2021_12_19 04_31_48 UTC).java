/*
* Circle class
*/
public class Circle {
	private static final double PI = 3.14;
	private double radius;
	/**
	 * constructor
	 * pre: none
	 * post: A Circle object created. Radius initialized to 1.
	 */
	public Circle() {
		radius = 1; //default radius
	}
	
	public Circle(double r) {
		radius = r;
	}
	/**
	 * Calculates the radius of the circle
	 * pre: none
	 * post: Radius has been changed
	 */
	public void setRadius(double newRadius) { //this is a modifier method
		radius = newRadius;
	}
	/**
	* Calculates the area of the circle.
	* pre: none
	* post: The area of the circle has been returned
	*/
	public double area() {
		double circleArea;
		circleArea = PI * radius * radius;
		return(circleArea);
	}
	/**
	* Returns the radius of the circle
	* pre: none
	* post: The radius of the circle has been returned
	*/
	public double getRadius() { //this is an accessor method
		return(radius);
	}
	
	public double getRadius(double rad){
		
		return rad;
		
	}
	public double circumference() {
		double circumference = 2 * PI * radius;
		return circumference;
		
	}
	
	public static void displayAreaFormula() {
		System.out.println("The formula for the area of a circle is a = pi*r*r");
	}
	/**
	* Determines if the object is equal to another Circle object.
	* pre: c is a Circle object
	* post: true has been returned if the objects have
	* the same radii. False has been returned otherwise
	 * @param Circle 
	*/
	public boolean equals(Object c) {//overriding the default equals statement as an overloaded method 
		Circle testObj =(Circle) c;//turning object c into a circle
		if (testObj.getRadius() == radius) {
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
	public String toString() {
		String circleString;
		circleString = "Circle has radius: " + radius;
		return(circleString);
	}
	
}