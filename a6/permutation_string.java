import java.util.*;

class Solution {
  
  static Set<String> permuteString(String s) {
    
    Set<String> result = new TreeSet<String>();
    
    if (s == null) {
            return null;
        } else if (s.length() == 0) {
            result.add("");
            return result;
        }
        char initial = s.charAt(0); // first character
        String rem = s.substring(1); // Full string without first character
        Set<String> words = permuteString(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                result.add(findPermutations(strNew, initial, i));
            }
        }
        return result;
  }
  
      public static String findPermutations(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
  
  
  
}//
