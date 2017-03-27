package weblab;
class Solution
{
  /**
   * @param array of integers to be sorted.
   */
	public static void quickSort(int[] elements){
	  rqsort(elements, 0, elements.length - 1);
  }
  
  public static void rqsort(int[] elements, int low, int high){
    if (elements == null || elements.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = elements[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (elements[i] < pivot) {
				i++;
			}
 
			while (elements[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			rqsort(elements, low, j);
 
		if (high > i)
		  rqsort(elements, i, high);
	}
  }
  
//
