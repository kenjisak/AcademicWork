/*
* Search.java
*/
public class Search {
/**
* Returns the index of the element nametofind in array array.
* -1 returned if element not found.
* pre: none
* post: index of nametofind has been returned. -1 has been
* returned if element not found.
*/
	public static int linear(String[] namess, String nametofind) {
		int index = 0;
		while ((!namess[index].equals(nametofind)) && (index < namess.length - 1)) {
		
			index += 1;
		}
		
		if (namess[index].equals(nametofind)) {
			return(index);
		} else {
			return(-1);
		}
	}
}