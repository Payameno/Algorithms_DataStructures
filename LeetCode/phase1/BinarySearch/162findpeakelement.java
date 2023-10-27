class Solution {
    public int findPeakElement(int[] nums) {

        //Define pointers
        int L = 0, N = nums.length, R = N - 1;
        
        while (L < R) {
            //Calculate the middle point
            int M = (L + R) / 2;

            if (nums[M] > nums[M + 1]) {
                R = M;
            } else {
                L = M + 1;
            }

        }

        return L;
    }
}

/*
Time complexity:
O(logn) as we are using the binary search approach

Space complexity:
O(1) it is constant

>Description:

Two pointers are defined, left and right
Find the middle point using the pointers

If the next element after middle point is larger, peak number is at the right
if next elemnet after the middle number is less, the peak is on the left

Example:
 * Input: nums = [1,2,1,3,5,6,4]
 *                          L
 *                        M
 *                          R
 */