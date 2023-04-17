
public class sorting {
	
	public static void insertionSort(Comparable[] items) {
		Comparable temp;
		int previousIndex;
		
		for (int index = 1; index < items.length; index++) { //start with second item
			temp = items[index];
			previousIndex = index - 1;
			
			while ((items[previousIndex].compareTo(temp)>0) && (previousIndex > 0)) {
				items[previousIndex + 1] = items[previousIndex];
				/* decrease index to compare current item to next previous item */
				previousIndex -= 1;
			}
			
			if (items[previousIndex].compareTo(temp)>0) {
				/* shift item in first element up into next element position */
				items[previousIndex + 1] = items[previousIndex];
				/* place current item at index 0 (first element) */
				items[previousIndex] = temp;
			} else {
				/* place current item at index ahead of previous item */
				items[previousIndex + 1] = temp;
			}
		}
	}
}
