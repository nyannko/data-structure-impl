import java.util.*;

class Solution {
  
  static Set<String> permuteString(String s) {
    
    Set<String> result = new TreeSet<String>();
    // call backtracking method here
    findPermutations(s,result,"");
    return result;
  }
  
  static void findPermutations(String s, Set<String> result, String string){
      if(s.length() < 1) {
          result.add(string);
      } else {
           for (int i = 0; i < s.length(); i++) {
              String sub = s.substring(i, i + 1);
              String rest = s.substring(0, i) + s.substring(i + 1);
              findPermutations(rest, result,string + sub);
          }
      }
    }
}
