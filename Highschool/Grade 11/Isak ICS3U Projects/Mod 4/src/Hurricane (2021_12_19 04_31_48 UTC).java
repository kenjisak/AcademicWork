import java.util.Scanner;
public class Hurricane {

	public static void main(String[] args) {
	int Hurricane;
	String one="74 – 95 mph or 64 – 82 kt or 119 – 153 km/hr";
	String two="96 – 110 mph or 83 – 95 kt or 154 – 177 km/hr";
	String three="111 – 130 mph or 96 – 113 kt or 178 – 209 km/hr";
	String four="131 – 155 mph or 114 – 135 kt or 210 – 249 km/hr";
	String five="greater than 155 mph or 135 kt or 249 km/hr";
	
	Scanner input=new Scanner(System.in);
	
	System.out.print("Enter Hurricane Category: ");
	Hurricane=input.nextInt();
	input.close();
	
	switch (Hurricane){
	
	case 1:
		System.out.println(one);
		break;
	case 2:
		System.out.println(two);
		break;
	case 3:
		System.out.println(three);
		break;
	case 4:
		System.out.println(four);
		break;
	case 5:
		System.out.println(five);
		break;
	default:
		System.out.println("That is not a hurricane category");
		break;
	}

	}

}
	