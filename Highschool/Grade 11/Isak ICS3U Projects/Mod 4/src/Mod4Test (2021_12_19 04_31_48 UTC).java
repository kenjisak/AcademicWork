import java.text.DecimalFormat;
public class Mod4Test {

	public static void main(String[] args) {
	double randomone= (750-100 +1)*Math.random() + 100;
	double randomtwo =(750-200 +1)*Math.random() + 100;
	
	 DecimalFormat df = new DecimalFormat("0");
	
	if (randomone>=100 && randomone <=199){
		System.out.println("***** Welcome to Locker Lottery!! *****");
		System.out.println("The winning locker is......... " + df.format(randomone)+"!");
		System.out.println("The second winning locker is......... " + df.format(randomtwo)+"!");
		System.out.println("Please come to the office to collect yout prize(s)!");
	}else{ 
		System.out.println("***** Welcome to Locker Lottery!! *****");
		System.out.println("The winning locker is......... " + df.format(randomone)+"!");
		System.out.println("Please come to the office to collect your prize(s)!");
	}

	}

}
