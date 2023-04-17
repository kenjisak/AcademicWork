import java.io.*;



public class Assign {

	public static void main(String[] args) {
		
		File textFile = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-Module 5\\src\\file1.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		
		try {
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null){
				System.out.println(lineOfText);
				
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) { 
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
			
		}
	}

}
