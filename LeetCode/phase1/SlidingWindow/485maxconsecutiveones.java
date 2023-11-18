package SlidingWindow;
import java.util.*;

class Solution {
    public int findMaxConsecutiveOnesS1(int[] nums) {
        //Define pointers
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = right + 1;
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}

/*
 * Time complexity:
 * S1:O(n)
 * 
 * Space complexity:
 * S1:O(1)
 * 
 * 
 * 
Example 1:
Input: nums = [1,1,0,1,1,1]
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. 
The maximum number of consecutive 1s is 3.


Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */