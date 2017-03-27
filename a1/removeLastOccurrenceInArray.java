class Solution {
	
	/**
	 * Takes the array and the last occuring element x,
	 * shifting the rest of the elements left. I.e.
	 * [1, 4, 7, 9], with x=7 would result in:
	 * [1,4,9].
	 * @param array to remove an entry from
	 * @return the shorter array
	 */
	public static int[] removeLastOccurence(int x, int[] array) {
		int size = array.length;
		if(size <= 0) {
		  return new int[0];
		}
		int[] newArray = new int[size - 1];
		int b = -1;
		for (int i = 0; i < size; i++) {
			if (array[i] == x) {
				b = i;
			}
		}
		if(b == -1) {
		  return array;
		}
		for (int j = 0; j < b; j++) {
			newArray[j] = array[j];
		}
		for (int m = b; m < size - 1; m++) {
			newArray[m] = array[m + 1];
		}
		
		return newArray;
	}
	
}//
