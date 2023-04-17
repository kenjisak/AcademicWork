import java.util.Scanner;
public class NumberCounts {

	public static void main(String[] args) {
		int[] num = new int[10];
		Scanner input = new Scanner(System.in);
		int number;
		System.out.println("Please enter a number: ");
		number=input.nextInt();
		boolean redo=true;
		while(redo==true){
			for (int i= 0;i<10;i++){
				int lastDig = number % 10;
				if (lastDig==i){
					num[i]++;
				}	
			}
			number = number /10;
			if(number==0){
				redo=false;	
			}
		}
		System.out.println("Number of occurences in each number: ");
		for (int i= 0;i<10;i++){
				System.out.println(i+"="+num[i]);
		}
		input.close();
	}

}
