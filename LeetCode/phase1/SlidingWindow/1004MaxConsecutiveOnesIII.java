package SlidingWindow;

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int right = 0, left = 0, n = nums.length;
        int maxLen = 0, zeroCounter = 0;

        while(right < n) {

            if (nums[right] == 0) {
                zeroCounter++;
            }

            //If the count of zeros larger than 1, shrink the window
            while (zeroCounter > k) {
                //it will post increment whether or not true
                if (nums[left++] == 0) {
                    zeroCounter--;
                }
            }

            //Count the number of consecutive ones
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
}

/*
 * 
Time complexity:
O(n) is linear. where n is the number of elements in the array

Space complexity:
O(1) constant


Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */