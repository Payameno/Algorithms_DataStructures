import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagramsOptimized {
  
      public List<List<String>> groupAnagrams(String[] strs) {
        
        //map sorted key to arrays of String
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String string : strs) {

          String key = generateKey(string);
          
          if (map.containsKey(key)) {
            map.get(key).add(string);
          } else {
            List<String> list = new LinkedList<>();
            list.add(string);
            map.put(key, list);
          }

        }

        //return map values
        return new ArrayList<>(map.values());
    }

    private String generateKey(String str) {
      
      int[] map = new int[26];
      char[] arr = str.toCharArray();
      
      for (char character : arr) {
        map[character - 'a']++;
      }
      
      StringBuilder string = new StringBuilder();

      for (int num : map) {
        string.append(num);
        string.append("#");
      }

      return string.toString();
 
    }

}

/*
 * Code optimized to remove sorting time complexity KlogK from the code
 * The code time complexity is O(n*k)
 * 
 * eat {a:1, e:1, t:1}
 * [26]
 * 1#0#0#.....#1#....#1...
 */