import java.util.ArrayList;
import java.util.Map;
import java.util.List;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {

    if (s == null || p == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }

    int start = 0;
    int end = 0;
    int sLen = s.length();
    int pLen = p.length();

    List<Integer> result = new ArrayList<>();

    if (sLen*pLen == 0 || pLen > sLen) {
      return result;
    }

    //map the p string
    Map<Character, Integer> map = new HashMap<>();

    for (int i=0; i < p.length(); i++) {
      map.put(p.charAt(i), map.getOrDefault(p.charAt(i) , 0)+1);
    }

    int toBeMatched = map.size();

    //sliding window 

    while (end < sLen) {

      char eChar = s.charAt(end);
      
      if (map.containsKey(eChar)) {

        int count = map.get(eChar);
        
        if (count ==1 ) {
          toBeMatched--;
        }

        map.put(eChar, count - 1);
      }
      end++;

      if (end - start > pLen) {

        char sChar = s.charAt(start);
        
        if (map.containsKey(sChar)) {

          int count = map.get(sChar);

          if (count == 0) {
            
            toBeMatched++;

          }

          map.put(sChar, count + 1);

        }

        start++;
      }

      //if all letters are matched in the character range 

      if (toBeMatched==0) {

        result.add(start);

      }

    }

    return result;
  }

}