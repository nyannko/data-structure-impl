package weblab;
import java.util.*;

class Solution
{
  /**
  * Returns the maximum possible integer given the string str containing digits, using 
  * maximum of n digits. Each digit in str can only be used once. 
  **/
	static int maxDigit(String str, int n) {
Set<Integer> result = new TreeSet<Integer>();
	      if(str == null ||n <= 0) {
	        return -1;
	      }
	      if (!str.matches("\\d+")) {
            return -1;
        }
      
        maxDigitHelper(str, n, "", result);
        Iterator<Integer> it = result.iterator();
        int max = it.next();

        while (it.hasNext()) {
            int comp = it.next();
            if (comp > max) {
                max = comp;
            }
        }
        return max;
	}
	
	/**
  * Creates a set of permutations in result based on string str with max n digits.
  **/
  static void maxDigitHelper(String str, int n, String acc, Set<Integer> result) {
        if (acc.length() == n || str.length() == 0) {
              result.add(Integer.parseInt(acc));
        } else {
            for (int i = 0; i < str.length(); i++) {
                String digit = str.substring(i, i + 1);
                String rest = str.substring(0, i) + str.substring(i + 1, str.length());
                String newString = acc + digit;
                maxDigitHelper(rest, n, newString, result);
            }
        }    
  }
}
