class Solution {

    public int lengthOfLIS(int[] nums) {
     
      int[] Nums = nums;
      int n = nums.length;
      imt[]cache new int[n];

      cache[n - 1] = 1;
      int maxLis = 1;

      for (int i = n - 2; i >= 0; i--) {
        int maxLisForRemaining = 0;

        for (int j = i + 1; j < n; j++) {

          if(Nums[i] < Nums[j]) {
            maxLisForRemaining = Math.max(maxLisForRemaining, cache[j]);
          }

          cache[i] = 1 + maxLisForRemaining;
          Math.max(maxLis, cache[j]);

        }
      }
      return maxLis;
    }

}

/*
 * Input: nums = [10,9,2,5,3,7,101,180]
  Output: 4
   Explanation: The longest increasing subsequence is 
   [2,3,7,101], therefore the length is 4.

 */