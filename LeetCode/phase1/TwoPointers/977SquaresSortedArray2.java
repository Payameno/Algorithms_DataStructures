class Solution {

    public int[] sortedSquares(int[] nums) {

      int n = nums.length;
      int[] result = new int[n];

      // define pointers
      int l = 0, r = n - 1, index = n - 1;;

      while (index >= 0) {

        int right = nums[r] * nums[r];
        int left = nums[l] * nums[l];

        if (right > left) {

          result[index] = right;
          r--;

        } else {

          result[index] = left;
          l++;

        }
        index--;

      }

      return result;
      
    }

}

//Input: nums = [-7,-3,2,3,11]
//                     l r