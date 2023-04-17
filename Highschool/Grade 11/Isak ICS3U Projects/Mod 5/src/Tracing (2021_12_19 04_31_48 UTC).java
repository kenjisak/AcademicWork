
public class Tracing {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		for (int i=0; i<= 4; i++){
			num1 =i* i;
			num2 +=num1;
			System.out.print(num1 + " ");
		}
	System.out.println(num2);
	}
}
