
public class SpanishNumber {

	public static void main(String[] args) {
	
		for (int i= 1; i <= 10;i++){
		String word = espanol(i);
		System.out.println(word);
		}
	
	

	}
	
	public static String espanol(int i) {

		if (i==1){
			return ("uno");
		}else if (i==2){
			return("dos");
		}else if(i==3){
			return("tres");
		}else if (i==4){
			return("quatro");
		}else if (i==5){
			return("cinqo");
		}else if (i==6){
			return("seis");
		}else if (i==7){
			return("siete");
		}else if (i==8){
			return("ocho");
		}else if (i==9){
			return("nueve");
		}else if (i==10){
			return("diez");
		}

		return(espanol(i));
		
		
		
		
		
	}
}
