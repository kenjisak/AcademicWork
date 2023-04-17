import java.io.*;
import java.util.Scanner;


public class Statisticspt2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		System.out.print("Please enter the name of your file: ");
		String filename = input.nextLine();
		
		
		
		File dataFile = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-Module 5\\src\\" + filename + ".dat");
		FileWriter out; 
		BufferedWriter writeFile;
		String name;
		int score;
		
		try {
			out = new FileWriter(dataFile);
			writeFile = new BufferedWriter(out);
			for (int i = 0; i < 5; i++){
				System.out.print("Enter Student name: ");
				name = input.nextLine();
				System.out.print("Enter test score: ");
				score = num.nextInt();
				writeFile.write(name);
				writeFile.newLine();    
				writeFile.write(String.valueOf(score));
				writeFile.newLine();
			}
		writeFile.close();
		out.close();
		System.out.println("Data has been saved.");
		
		}catch (IOException e){
			System.out.println("Problem writing to file.");
			System.err.println("IOException: " + e.getMessage());
		}
		
		
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
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
