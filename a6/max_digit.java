import java.util.*;

class Solution
{
  /**
  * Returns the maximum possible integer given the string str containing digits, using 
  * maximum of n digits. Each digit in str can only be used once. 
  **/
	static int maxDigit(String str, int n) {
	      if(str == null ||n <= 0) {
	        return -1;
	      }
	      if (!str.matches("\\d+")) {
            return -1;
        }
	      
	      if(n > str.length()) {
            n = str.length();
        }
        Set<Integer> result = new HashSet<>();
        maxDigitHelper(str, n, "", result);
        int max = Collections.max(result);
        return max;
	}
	
	/**
  * Creates a set of permutations in result based on string str with max n digits.
  **/
  static void maxDigitHelper(String str, int n, String acc, Set<Integer> result) {
        if (n == 0) {
            permutation("", acc, result);
        }
        else {
            for (int i = 0; i < str.length(); i++)
                maxDigitHelper(str.substring(i + 1),  n-1, acc + str.charAt(i), result);
        }
  }
  
    static void permutation(String prefix, String str, Set<Integer>result) {
        int n = str.length();
        if (n == 0) {System.out.println(prefix); result.add(Integer.parseInt(prefix));}
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),result);
        }
    }
  
}
//
