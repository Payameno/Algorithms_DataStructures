package SlidingWindow;

class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
      //Define pointers
      int l = 0, r = 0;
      
      //Define sum and min
      int sum = 0 , n = nums.length;
      int min = Integer.MAX_VALUE; //2147483647 max pos int

      while (r < n) {
          //Add current element to sum
          sum += nums[r];
          //contract window
          while (target <= sum) {
              min = Math.min(min, r - l + 1);
              sum -= nums[l];
              l++;
          }
          r++;
      }
      return min == Integer.MAX_VALUE? 0: min;
      
  }
}
