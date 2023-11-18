package SlidingWindow;

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {

        char[] chars = s.toCharArray();

        int n = chars.length, mostFreq = 0, maxLen = 0;
        int right =0, left = 0;

        //Map character to the repetition
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {

            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(chars[right]));

            //Shrink the window if k is reached
            if (((right - left) +1) - mostFreq > k) {
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }

            //calculate the length
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
/*
Sliding window technique

Time complexity:
O(n) linear, where n is the number of characters in the array

Space complexity:
O(1) constant



 Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */