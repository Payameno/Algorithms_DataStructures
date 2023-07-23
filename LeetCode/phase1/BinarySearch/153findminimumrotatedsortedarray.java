class Solution {

    public int findMin(int[] nums) {

      //Pointers
      int L = 0, R = nums.length-1;

      //Base
      if (nums[L] < nums[R]) return nums[L];

      //Find the middle point
      while (L+1 < R) {

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
//Input: nums = [4,5,6,7,0,1,2]
//                       ^
//                     ^
