class Solution {

  public int removeDuplicates(int[] nums) {

      int n = nums.length;

      //base
      if (n < 3) return n;

      //define pointers and counter
      int l = 0, r = 1, count = 0;

      //solution
      while (r < n) {

        if (nums[l] != nums[r]) {

          l++;
          nums[l] = nums[r];
          count = 0;

        } else if (nums[l] == nums[r] && count < 1) {

          count++;
          nums[l++] = nums[r];
          
        }
        r++;


    }
      //output
      return l+1;
  }

}

//Input: nums = [0,0,1,1,1,1,2,3,3]
//                         l     
//                               r
//c=1

//Input: nums = [1,1] k = 2