
public class sort {
	
	public static void selectionsort (Comparable[] items) {
		
		for (int index = 0; index < items.length; index++){
			for (int subindex = index; subindex < items.length; subindex++){
				
				if(items[subindex].compareTo(items[index]) < 0){
					Comparable temp = items[index];
					items[index] = items[subindex];
					items[subindex] = temp;
				}
			}
		}
	}
}
