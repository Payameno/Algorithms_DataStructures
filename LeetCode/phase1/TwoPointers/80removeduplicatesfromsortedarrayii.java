class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        boolean seenDup = false;

        //Base case
        if (len < 2) return len;

        //Define pointers
        int cp = 0; // Current pointer
        int ep = 1; // explorer pointer

        //iterate through the array
        while (ep < len) {
            if (nums[cp] == nums[ep]) {
                if (seenDup) {
                    ep++;
                } else {
                    seenDup = true;
                    cp++;
                    nums[cp] = nums[ep];
                    ep++;
                } 
            } else {
                    nums[++cp] = nums[ep++];
                    seenDup = false;
                
            }
        }
        return cp + 1;
    }
}

/*
Time complexity:
O(n) where n is the number of integers in the array

Space complexity:
O(1)

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */