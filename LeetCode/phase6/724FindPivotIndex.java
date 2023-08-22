class Solution {

    public int pivotIndex(int[] nums) {
      //base
      if (nums.length == 1) return 0;

      int sum = 0, pivotIdx = -1;
      //get the sum afte the pivot = 0
      for (int num : nums) {
        sum += num;
      }

      int sumR = sum, sumL = 0;

      for (int i = 0; i < nums.length; i++) {

        sumR -= nums[i];
        if (sumR == sumL) {
          pivotIdx = i;
          return pivotIdx;
        };
        sumL += nums[i];
      }
      return pivotIdx;
    }

}


//Input: nums = [1,7,3,6,5,6]
//Output: 3