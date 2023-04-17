import java.io.*;
public class Statistics {

	public static void main(String[] args) {

		File dataFile = new File("L:\\mailbox\\Shannon McDougall\\test1.dat");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		//String score;
		double avgScore;
		double totalScores = 0;
		int numScores = 0;
		int val = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		try {
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null){
				System.out.println(lineOfText);
				//lineOfText = readFile.readLine();//number
				try {
					totalScores += Double.parseDouble(lineOfText);
					numScores += 1;
					val = Integer.parseInt(lineOfText);
					if (val > max){
						max = val;
					}
					
					if (val < min){
						min = val;
					}
					
				} catch (NumberFormatException e) { 
					//not a number
				}
			
				
				
			}
			avgScore = totalScores / (numScores);
			System.out.println("Average = " + Math.round(avgScore));
			System.out.println("Highest Score is: " + max);
			System.out.println("Lowest Score is:  " + min);
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
