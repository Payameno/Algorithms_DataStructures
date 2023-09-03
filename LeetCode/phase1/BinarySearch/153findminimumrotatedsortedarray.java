class Solution {

    public int findMin(int[] nums) {

      //Pointers
      int L = 0, R = nums.length-1;

      /*
      Find the middle point and adjust pointers
       * When using L < R, there's a possibility that in some cases, 
       * the algorithm takes an extra iteration, 
       * leading to worse performance for larger input sizes 
       * ->Whenever L and R become adjacent the loop exists
       */
      while (L+1 < R) {

        //Base case
        if (nums[L] < nums[R]) return nums[L];

        int m = L + (R - L) / 2;

        if (nums[m] > nums[R]) {
          L = m;
        } else {
          R = m;
        }
      }
      return Math.min(nums[L], nums[R]);
    } 

}

/*
 * Time complexity: Binary Search Olog(n)
 * Input: nums = [4,5,6,7,0,1,2]
 *                        ^
 *                          ^
 */
