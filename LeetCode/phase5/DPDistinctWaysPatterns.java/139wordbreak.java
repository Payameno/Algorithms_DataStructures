import java.util.*;

class Solution {
    Set<String> dict;
    Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return helper(s);
    }

    private boolean helper(String s) {
        //Base
        if (s.length() == 0 || s == null) return true;

        //Cache implementation
        if (cache.containsKey(s)) return cache.get(s);

        int n = s.length();
        for (int i = 0; i <= n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, n);

            if (dict.contains(left) && helper(right)) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);
        return false;
    }

}

/*
 Time complexity: 
 O(2^n)
The number of recursive calls grows exponentially with the length of the string
for each character the functions tries to break the input string to words

 Space complexity:
 O(n) for memoization cache + O(n) for recursion stack

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]

Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */