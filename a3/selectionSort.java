package weblab;
class Solution
{
  /**
   * @param array of integers to be sorted.
   */
	public static void selectionSort(int[] elements){
	  int min;
	  int size = elements.length;
	  for(int i = 0; i < size - 1; i++) {
	    min = i;
	    for(int j = i + 1; j < size; j++) {
	      if(elements[min] > elements[j]) {
	        min = j;
	      }
	    }
	    int temp = elements[min];
	    elements[min] = elements[i];
	    elements[i] = temp;
	    
	  }
	}
}
//
