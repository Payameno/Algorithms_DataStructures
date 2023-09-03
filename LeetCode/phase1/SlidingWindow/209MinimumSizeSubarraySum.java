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

/*
 * Time Complexity: O(n)

The outer while loop iterates through the array once, giving O(n) time.
The inner while loop may iterate several times but in total across all iterations of the outer loop it does not exceed O(n).
So the overall time complexity is O(n).
Space Complexity: O(1)

No extra space is used, only integer variables. The input array is not modified.
So the space complexity is constant O(1).
In summary:

Time Complexity: O(n)
Space Complexity: O(1)
 */