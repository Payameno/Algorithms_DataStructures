class Solution {
    public int search(int[] nums, int target) {

      int midIdx = 0;
      int size = nums.length;
      int leftIdx;
      int rightIdx;
      int ans = -1;

      if(size%2==0) {
        midIdx = size/2;
      } else if (size%2!=0) {
        midIdx = Math.round(size/2);
      }

      if (target==nums[midIdx]) {
        ans = midIdx;
      } else if (nums[midIdx]>target) {
        leftIdx = 0;
        rightIdx = midIdx-1;

        while (leftIdx<=rightIdx) {
          if (nums[leftIdx]==target) {
            ans = leftIdx;
          } else if (nums[rightIdx]==target) {
            ans = rightIdx;
          } else {
            leftIdx++;
            rightIdx--;
          } 

          if (leftIdx==rightIdx && leftIdx!=target) return -1;
        }
        
      } else if (target>nums[midIdx]) {

        leftIdx = midIdx+1;
        rightIdx = size-1;

        while (leftIdx<=rightIdx) {
          if (nums[leftIdx]==target) {
            ans = leftIdx;
          } else if (nums[rightIdx]==target) {
            ans = rightIdx;
          } else {
            leftIdx++;
            rightIdx--;
          } 

          if (leftIdx==rightIdx && leftIdx!=target) return -1;
        }
        
      }
      return ans;
    }
}