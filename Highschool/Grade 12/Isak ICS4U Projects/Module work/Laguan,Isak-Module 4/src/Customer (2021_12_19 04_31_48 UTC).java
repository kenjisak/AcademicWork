/**
* Customer class.
*/
public class Customer {
	private String firstName, lastName, street, city, state, zip;
	/**
	* constructor
	* pre: none
	* post: A Customer object has been created.
	* Customer data has been initialized with parameters.
	*/
	public Customer(String fName, String lName, String str, String c,String s, String z) {
	
		firstName = fName;
		lastName = lName;
		street = str;
		city = c;
		state = s;
		zip = z;
	}
	
	/**
	 * pre: none
	 * post: street has been changed
	 */
	public void changestreet(String newstreet){
		street = newstreet;
	}
	/**
	 * pre: none
	 * post: city has been changed
	 */
	public void changecity(String newcity){
		city = newcity;
	}
	/**
	 * pre: none
	 * post: state has been changed
	 */
	public void changestate(String newstate){
		state = newstate;
	}
	/**
	 * pre: none
	 * post: zip has been changed
	 */
	public void changezip(String newzip){
		zip = newzip;
	}
	
	/**
	* Returns a String that represents the Customer object.
	* pre: none
	* post: A string representing the Account object has
	* been returned.
	*/
	public String toString() {
		String custString;
		custString = firstName + " " + lastName + "\n";
		custString += street + "\n";
		custString += city + ", " + state + " " + zip + "\n";
		return(custString);
	}
}