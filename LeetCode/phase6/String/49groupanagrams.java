import java.util.*;
class solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        //Map letters to an array of words
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {

            //sorts and generates same key with equal letters
            String key = generateKey(str);

            if (!map.containsKey(key)) {
                map.put(key,new LinkedList<>());
            } 
            
            List<String> list = map.get(key);
            list.add(str);
        }


        //Return an array with list of Strings
        return new ArrayList<>(map.values());
    }

    private String generateKey(String str) {
        int[] map = new int[26];

        //For each index representing each letter, number increases with reoccurence
        for (char character : str.toCharArray()) {
            map[character - 'a']++;    
        }

        StringBuilder sb = new StringBuilder();
        //converts the int array to a string representing re-occurence ex 1#0#0#1...
        for (int num : map) {
            sb.append(num);
            sb.append('#');
        }

        return sb.toString();
    }

}

/*
Time complexity: o(nk)
n = number of Strings in the array
k = number of characters of the lengthiest String in the array

Space complexity:
O(n)

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/
