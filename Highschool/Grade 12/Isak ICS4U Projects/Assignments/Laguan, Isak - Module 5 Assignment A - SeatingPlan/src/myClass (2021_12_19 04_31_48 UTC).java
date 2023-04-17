
public class myClass {
private String[][] classboard;
private int rows,columns;
/**
* constructor
* pre: none
* post: Class object created. Displays the seating plan to go along with it
*/
	public myClass(int row,int col){
		rows = row;
		columns = col;
		classboard = new String[rows][columns];
		
		for(int roww = 0; roww < classboard.length; roww++) {
			for (int coll = 0; coll < classboard[0].length; coll++) {
				classboard[roww][coll] = "EMPTY";
				System.out.print("[" + classboard[roww][coll] + "]");
			}
			System.out.println();
		}
	
		
	}
	/**
	* Displays the seating plan
	* pre: none
	* post: seating plan has been displayed.
	*/
	public void displayseatingplan(){
		
		for(int roww = 0; roww < classboard.length; roww++) {
			for (int coll = 0; coll < classboard[0].length; coll++) {
				System.out.print("[" + classboard[roww][coll] + "]");
			}
			System.out.println();
		}
	}
	/**
	* Displays row stated by the user
	* pre: none
	* post: row stated by the user has been displayed.
	*/
	public void displayrow(int rowgiven){
		
		
		for (int coll = 0; coll < classboard[0].length; coll++) {
			System.out.print("[" + classboard[rowgiven][coll] + "]");			
		
		}
			
		
		}
	/**
	* Displays column stated by the user
	* pre: none
	* post: column stated by the user has been displayed.
	*/
	public void displaycol(int colgiven){
		
		
		for(int roww = 0; roww < classboard.length; roww++) {
			
			System.out.print("[" + classboard[roww][colgiven] + "]");
			System.out.println();
		}
			
		
		}
	/**
	* Sets the student to their seat with the info given by the user
	* pre: none
	* post: student occupied seat
	*/
	 public void addstudent(String name, int rowentered, int colentered){
		 classboard[rowentered-1][colentered-1] = name;	
	}
	 /**
		* Returns a boolean defining the state of the seat if its vacant or not
		* pre: none
		* post: boolean has been returned.
		*/
	 public boolean studentcheck(int rowentered, int colentered){
		 if (classboard[rowentered-1][colentered-1].equals("EMPTY")){
			//does this array equal empty? yes its available
			 return true;
		 }else{
			 // does this array equal empty? no its taken
			 return false;
		 }
		
	 }
}