package SlidingWindow;

class Solution {

    public String minWindow(String s, String t) {

        //ASCI characters, initialized as 0s
        int[] map = new int[128];
        char[] arr = s.toCharArray();

        //Deifne pointers
        int left = 0, right = 0, n = arr.length;
        int minLength = Integer.MAX_VALUE, countSubStringChar = 0;
        String minLengthString = "";

        //Map substring
        for (char cur : t.toCharArray()) {
            map[cur]++;
        }

        //Perform iterations through the character array
        while (right < n) {

            //Operation
            map[arr[right]]--;
            if (0 <= map[arr[right]]) {
                countSubStringChar++;
            }


            //Shrin the window if it contains all characters
            while (countSubStringChar == t.toCharArray().length) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    minLengthString = s.substring(left, right + 1);
                }


            //shrink the window
            map[arr[left]]++;
            if (0 < map[arr[left]]) {
                countSubStringChar--;
            }
            left++;

        }

        right++;

        }
        return minLengthString;
    }

}

/*

Time complexity:

N number of characters in S 
M number of characters in t

O(M) for the mapping
O(N) for searching for min sub

O(M+N) is the time complexity

Space complexity:
O(1) constant

                 Input: s = "ADOBECODEBANC", t = "ABC"
                                      ----
                  A = 0
                  B = 0
                  C = 0
                  count 3
                  BANC


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */