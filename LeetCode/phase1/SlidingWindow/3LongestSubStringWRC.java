package SlidingWindow;
import java.util.*;

class solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        int maxLength = Integer.MIN_VALUE;

        //Map character to count
        HashMap<Character, Integer> map = new HashMap<>();

        //Define the pointers
        int Left = 0, Right = 0;

        //Expand the window
        while(Right < n) {
            map.put(sArr[Right], map.getOrDefault(sArr[Right], 0) + 1);

            //Coindition to shrink the window
            if (map.size() < (Right - Left) - 1) {
                if (map.get(sArr[Left]) == 1) {
                    map.remove(sArr[Left]);
                } else {
                    map.put(sArr[Right], map.get(sArr[Right]) - 1);    
                }
                Left++;
            }

            maxLength = Math.min(maxLength, (Right - Left) +1);

            Right++;
        }
        return maxLength == Integer.MIN_VALUE? 0 : maxLength;
    }
}

/*
 * Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Solution using sliding window



Input: s = "abcabcbb"
                 L
                   R
maxLength = 3
Map {a:1, b:1, c:1}

Condition: each character should not have a value greater than 1
The window will be exapnded and when condition is met it will be shrank

Time Complexity:
Linear O(n)

Space Complexity:
O(n)
the worse case when all characters inside the string are unique
 */
