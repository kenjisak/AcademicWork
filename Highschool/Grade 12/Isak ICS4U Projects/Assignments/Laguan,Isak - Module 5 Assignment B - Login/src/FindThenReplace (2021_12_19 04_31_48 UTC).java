import java.io.*;

public class FindThenReplace {

	public static void main(String[] args) {
	//read all lines first and convert all lines into a string
		//have a counter for the number array 
		// put all the strings into an array
		//for loop ?check each string array and lineoftex.replace all (str 1, str2)
		
		File textFile = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\replace.txt");
		FileReader in;
		BufferedReader readFile;
		String lineoftext;
		int arraycount = 0;
		String[] text = new String[arraycount];
		
		
		
		try {
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			while ((lineoftext = readFile.readLine()) != null){
				text[arraycount] = lineoftext;
				arraycount++;
				
			}
		}catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) { 
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
			
		}
		
	}

}
