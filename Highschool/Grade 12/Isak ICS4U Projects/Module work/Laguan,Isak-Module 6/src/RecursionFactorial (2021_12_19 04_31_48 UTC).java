
public class RecursionFactorial {

	public static int intfactorial(int num){
		if(num==0){
			return 1;	
		}else{
			return(num * intfactorial(num-1));
		}
		
		
	}
	public static void main(String[] args) {
		int x = intfactorial(5);
		System.out.println(x);
	}

}
