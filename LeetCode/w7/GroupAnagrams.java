import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class GroupAnagrams {

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
      
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      return new String(arr);

    }

}

/*
Time complexity O(n*klogk);
Klogk is the time complexity of sorting


Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */