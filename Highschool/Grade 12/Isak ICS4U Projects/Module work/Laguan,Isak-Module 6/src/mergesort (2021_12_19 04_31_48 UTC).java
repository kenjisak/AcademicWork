
public class mergesort {
	private static void merge(Comparable[] items , int start , int mid , int end){
		String[] temp = new String[items.length];
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;
		
		while (! (pos1 > mid && pos2 > end)) { 
			if ((pos1 > mid ) || (( pos2 <= end) && (items[pos2].compareTo(items[pos1]) < 0))){
				temp[spot] = (String) items[pos2];
				pos2 += 1;
			} else {
				temp[spot] = (String) items[pos1];
				pos1 += 1;
			}
			spot += 1;
		}
		for (int i = start; i<= end; i++){
			items[i] = temp[i];
		}
	}
	
	
	public static void mergesortt(Comparable[] items, int start , int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesortt(items, start , mid);
			mergesortt(items , mid + 1, end);
			merge(items, start, mid, end);
		}
	}
}
