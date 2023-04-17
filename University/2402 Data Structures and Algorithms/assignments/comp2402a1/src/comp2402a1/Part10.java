package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part10 {
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		//save all inputs, then sort using sort and reverse.
		//pick the first input from the reversed input.
		//find it in the list and remove all the inputs before it
		//printout
		//restart
		List<String> firstinputlist = new ArrayList<String>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			firstinputlist.add(line);
		}
		//save all inputs
		//for loop till the sorted inverse pos 0 is the same as the prev one which is new list0
		//start for here

		/*
		while (!end){
			List<String> inputlist = new ArrayList<String>(firstinputlist);
			reversedlist.sort(Collections.reverseOrder());//sorts to have the largest as first
			int pos = inputlist.indexOf(reversedlist.get(0));//gets the position of the first in the sorted list
			finallist.add(reversedlist.get(0)); //adds the largest out of the sorted into the final output list
			if (pos >= 0) {//clears input list before biggest string
				firstinputlist.subList(0, pos + 1).clear();
			}
			reversedlist.clear();//resets
			reversedlist = new ArrayList<String>(firstinputlist);//fills the reversed list with new updated list
			if (inputlist.size() == 1){
				end = true;
			}
		}
		*/
		List<String> reversedlist = new ArrayList<String>(firstinputlist);
		List<String> finallist = new ArrayList<String>();// output list
		List<String> inputlist;
		do{
			inputlist = new ArrayList<String>(firstinputlist);
			reversedlist.sort(Collections.reverseOrder());//sorts to have the largest as first
			int pos = inputlist.indexOf(reversedlist.get(0));//gets the position of the first in the sorted list
			finallist.add(reversedlist.get(0)); //adds the largest out of the sorted into the final output list
			if (pos >= 0) {//clears input list before biggest string
				firstinputlist.subList(0, pos + 1).clear();
			}
			reversedlist.clear();//resets
			reversedlist = new ArrayList<String>(firstinputlist);//fills the reversed list with new updated list
		}while(inputlist.size() != 1);
		//end for here
		for (String text : finallist){
			w.println(text);
		}
	}
	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
