import java.util.Scanner;
import java.text.DecimalFormat;


public class Timeconverter {

	public static void main(String[] args) {
		int choice;
		boolean restart=true;
		Scanner input=new Scanner(System.in);
		System.out.println("1.Hours to minutes");
		System.out.println("2.Days to hour");
		System.out.println("3.Minutes to hours");
		System.out.println("4.Hours to days");
		
		while (restart==true){
			System.out.println("Please enter the number of operation you'd like to do: ");
		
			choice=input.nextInt();
	
			if (choice==1){
				hourstominutes();
				restart=false;
			}else if(choice==2){
				daystohours();
				restart=false;
			}else if(choice==3){
				minutestohours();
				restart=false;
			}else if(choice==4){
				hourstodays();
				restart=false;
			}
		}
		input.close();
	}
	public static void hourstominutes(){
		System.out.println("Enter number of hours: ");
		Scanner input=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		double hours;
		hours=input.nextDouble();
		double calc = hours * 60;
		
		System.out.println("There are " + df.format(calc) + " minutes in " + hours + " hour(s)");
		input.close();
	}
	public static void daystohours(){
		Scanner input=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Enter number of days: ");
		double days;
		days=input.nextDouble();
		double calc = days * 24;
		System.out.println("There are " + df.format(calc) + " hours in " + days + " day(s)");
		input.close();
	}
	public static void minutestohours(){
		Scanner input=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Enter number of minutes: ");
		double minutes;
		minutes=input.nextDouble();
		double calc = minutes / 60;
		System.out.println("There are " + df.format(calc) + " hours in " + minutes + " minute(s)");
		input.close();
	}
	public static void hourstodays(){
		Scanner input=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Enter number of hours: ");
		double hours;
		hours=input.nextDouble();
		double calc = hours / 24;
		System.out.println("There are " + df.format(calc) + " days in " + hours + " hour(s)");
		input.close();
	}

}
