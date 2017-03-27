import java.util.Queue;
import java.util.*;

class Solution {
  /**
	 * Returns an array of buckets (represented by Queues). Each bucket contains
	 * exactly one value of elements.
	 * 
	 * @param array
	 *            to fill the buckets with.
	 * @return an array of buckets
	 */
	@SuppressWarnings("unchecked")
	public static Queue<Integer>[] fillBuckets(int[] array) {
	  int size = array.length;
	  if(size == 0) {
	    return new Queue[0];
	  }
	  int vmin = array[0];
	  int vmax = array[0];
	  for(int i = 0; i < size; i++) {
	    if(array[i] < vmin) {
	      vmin = array[i];
	    }else if(array[i] > vmax) {
	      vmax = array[i];
	    }
	  }
    Queue<Integer>[] buckets = new Queue[vmax-vmin+1];
    
    for (int i = 0; i < buckets.length; i++) {
 
			buckets[i] = new LinkedList<Integer>();
 
		}
 
		for (int i = 0; i < array.length; i++) {
 
			int val = array[i];
 
			buckets[val - vmin].add(val);
 
		}
 
    return buckets;
	}
}

//
