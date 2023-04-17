import java.util.Scanner;


public class BackwardsName {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;
		
		System.out.print("Enter your name please: ");
		
		name = input.nextLine();
		
		for (int i = name.length()-1;i<=name.length()-1; i--){
			if(i>=0){
				System.out.println(name.charAt(i));	
			}else{
				
			}
			
		}
		input.close();
	}				

}
//System.out.println(name.charAt(3));
//make a for loop to display the characters at the max character position then start from there
//(3;if i is less than or equal to 3; i minus 1)
//if i is 0 then dont print out
//if i is bigger than 0 then print