class 154findminimumrotatedsortedarrayii {

      public int findMin(int[] nums) {

        //Define pointers
        int L = 0, R = nums.length - 1;

        while (L + 1 < R) {
          int mid = L + (R - L) / 2;

          if (nums[L] < nums[R]) return nums[L];

          if (nums[L] <= nums[mid]) {
            L++;
          } else {
            R--;
          }
        }
        return Math.min(nums[L], nums[R]);
    }

}

/*
 * Input: nums = [2,2,2,0,1]
 *                L
 *                         R
 *                    M
 * 
 * Time complexity for worst case scenario:
 * O(n) where we have n elements and n-2 elements are of the same value
 * In normal cases time complexity would be O(logn) as the range 
 * decreases into halves by each iteration
 */