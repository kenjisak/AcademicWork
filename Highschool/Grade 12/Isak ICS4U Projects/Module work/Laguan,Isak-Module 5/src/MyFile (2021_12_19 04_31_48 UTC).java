import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MyFile {

	public static void main(String[] args) {
		File textFile = new File("c:\\temp\\zzz.txt");
		
		if(textFile.exists())	{
			System.out.println("File already exists.");
		}else{
			try {
				textFile.createNewFile();
				System.out.println("New file created.");
			} catch (IOException e) {
				System.out.println("File could not be created.");
				System.err.println("IOException: " + e.getMessage());
			}
			
			
		}
		
		System.out.println("Would you like to keep or delete the file?");
		Scanner input = new Scanner(System.in);
		String ans;
		ans = input.nextLine();
		
		if(ans.equals("keep")){
			System.out.println("Cool.");
		}else{
			try {
				textFile.delete();
				System.out.println("File has been successfully deleted");
			}catch (SecurityException e){
				System.out.println("File could not be deleted.");
				System.err.println("IOException: " + e.getMessage());
				
			}
		}
	}

}
