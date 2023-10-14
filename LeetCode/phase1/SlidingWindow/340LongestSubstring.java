package SlidingWindow;
import java.util.*;

class solution {

    public int lengthOfLongestSubstringKd(int k, String s) {

        char[] sArr = s.toCharArray();
        int n = sArr.length;
        int maxLength = Integer.MIN_VALUE;

        // Define pointers
        int Left = 0, Right = 0;

        //Map Character to count
        HashMap<Character, Integer> map = new HashMap<>();

        //Expand the window
        while (Right < n) {
            map.put(sArr[Right], map.getOrDefault(sArr[Right], 0) + 1);

            //Condition to Shrink
            while (map.size() > k) {
                if (map.get(sArr[Left]) == 1) {
                    map.remove(sArr[Left]);
                } else {
                    map.put(sArr[Right], map.get(sArr[Right]) - 1);    
                }
                Left++;
            }
            maxLength = Math.min(maxLength, (Right - Left) + 1);
            Right++;
        }

        return maxLength == Integer.MIN_VALUE? 0 : maxLength;

    }
    
}


/*
 * Longest substring with at most K distinct characters
 * String s, Integer K,
 * return the longest substring that contains at most k distinct characters
 * 
 * 
 * Solution: 
 * Sliding window - 
 * You should consider that in sliding window solution, 
 * the window's width can expand  and shrink
 * 
 * Example: s = "eceba" , k = 2
 *               R
 *                L
 * {e: 1, c:1} 
 * 
 * Condition: Size > 2 -> shrink the window
 * 
 * 
 * Time complexity:
 * O(n)
 * 
 * Space complexity:
 * o(n)
 * Worse case when K == the length of the string
 * 
 */