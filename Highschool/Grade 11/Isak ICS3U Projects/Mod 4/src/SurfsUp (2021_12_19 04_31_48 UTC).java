import java.util.Scanner;
public class SurfsUp {

	public static void main(String[] args) {
double wave;

System.out.print("Enter wave height: ");
Scanner input = new Scanner(System.in);
wave = input.nextDouble();
input.close();

if (wave >= 6) {
	System.out.println("Great day for surfing");
}else if(wave<6 && wave>=3){
	System.out.println("Go body boarding");  
}else if(wave>=0 && wave<3){
	System.out.println("Whoa! What kind of surf is that?");
}
	}

}
