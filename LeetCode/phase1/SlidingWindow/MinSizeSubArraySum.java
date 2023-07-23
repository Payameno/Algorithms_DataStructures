package SlidingWindow;

public class MinSizeSubArraySum {
  
  public int minSubArrayLen(int target, int[] nums) {
    
    //Define pointers
    int r = 0, l = 0;
    
    //min & sum
    int min = Integer.MAX_VALUE, sum = 0;
    int n = nums.length;

    //Calculate sum + move pointers
    while (r < n) {

      //add the current element
      sum += nums[r];
    
      //contract window
      while (target <= sum) {

        min = Math.min(min, r - l + 1);
        sum -= nums[l];
        l++;

      } 
      r++;

    }

    return min == Integer.MAX_VALUE? 0 : min;

  }
  
}

//Input: target = 7, nums = [2,3,1,2,4,3]
//                             ^
//                                 ^
//sum
//min