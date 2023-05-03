class Solution {
    public int search(int[] nums, int target) {

      //Solving using two pointer logic

      int midIdx = 0;
      int leftIdx = 0;
      int rightIdx = nums.length-1;

      while (leftIdx<=rightIdx) {
        midIdx = Math.round(leftIdx+rightIdx)/2;
        
        if (nums[midIdx]==target) return midIdx;
        if (nums[rightIdx]==target) return rightIdx;
        if (nums[leftIdx]==target) return leftIdx;

        if (nums[leftIdx]<=nums[midIdx]) {

          if (target>nums[midIdx] || target<nums[leftIdx]) {
            leftIdx = midIdx+1;
          } else {
            rightIdx = rightIdx-1;
          }

        } else {

          if (target<nums[rightIdx] || target>nums[midIdx]) {
            rightIdx = rightIdx-1;
          } else {
            leftIdx = leftIdx-1;
          }

        }
      }

      return -1;
    }
}