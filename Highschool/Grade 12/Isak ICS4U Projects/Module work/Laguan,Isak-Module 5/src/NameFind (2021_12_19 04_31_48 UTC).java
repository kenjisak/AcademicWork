import java.util.Scanner;


public class NameFind {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int namesnum;
		int location;
		System.out.print("Please enter the number of names you'd like to enter: ");
		namesnum=input.nextInt();
		
		String[] names= new String[namesnum];
		input.nextLine();
		
		System.out.println("Enter the names:");
		for (int i = 0;i < names.length; i++){
			
			names[i]=input.nextLine();
		}
		
		System.out.print("Enter a name to find: ");
		Scanner nameword = new Scanner(System.in);
		String word = nameword.nextLine();
		
		location = Search.linear(names, word);
		
		if (location == -1) {
			System.out.println("Sorry, name not found in array.");
		} else {
			System.out.println("The name is at " + (location + 1) );
		}
		//input.close();
	}

}
