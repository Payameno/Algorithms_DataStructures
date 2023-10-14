package SlidingWindow;
import java.util.*;

class solution {
/*
 * 1- What if there is only one character in the string? base case covers this
 * 2- do Lower and Upper cases matter in solving this problem?
 * In the following solution the HashMap does not distinguish between 
 * uppercase and lowercase.
 * In a hashmap characters are treated as different if their hashcode is different
 */
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        char[] strArr = s.toCharArray();
        int n = strArr.length;
        int maxLength = Integer.MIN_VALUE;

        //Base
        if (n < 2) return 0;

        //Define the map to track character repition
        HashMap<Character, Integer> map = new HashMap<>();

        //Define pointers
        int Left = 0, Right = 0;


        //Find the length
        while (Right < n) {
            //Expand the window
            map.put(strArr[Right], map.getOrDefault(strArr[Right], 0) + 1);

            //Condition to contract the window
            if (map.size() > 2) {
                if (map.get(strArr[Left]) == 1) {
                    map.remove(strArr[Left]);
                } else {
                    map.put(strArr[Left], map.get(strArr[Left]) - 1);
                }
                Left++;
            }


            maxLength = Math.max(maxLength, (Right - Left) + 1);

            Right++;
        }
        return maxLength;
    }
    
}

/*
 * Problem:
 * Given a string s, find the length of the longest substring t, that contains at most 
 * 2 distinct characters
 * 
 * Example1:
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3
 * 
 * Solution:
 * Sliding window
 *  * Input: "eceba"
 *            L
 *             R
 * 
 * Map {e:1, c:1}
 * Condition: max 2 distinct characters. Size == 2 checked
 * MaxLength: 2

 * 
 *  *  * Input: "eceba"
 *               L
 *                 R
 *  * Map {e:2, c:1}
 * Condition: max 2 distinct characters. Size == 2 checked
 * MaxLength: 3
 * 
 *  *  *  * Input: "eceba"
 *                     L
 *                      R
 * 
 * Time complexity:
 * Linerar BigO(n)
 * 
 * Space complexity:
BigO(1) to map each character to the number of repitition
 * In the worse case the map will write two characters into HashMap 
 */