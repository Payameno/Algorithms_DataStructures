function maxSubArray(nums: number[]): number {

  let currentMax = nums[0];
  let max = nums[0];

  for (let i =1; i<nums.length; i++) {
    currentMax = Math.max(nums[i],nums[i] + currentMax);
    max = Math.max(currentMax, max);
  }

  return max;

};

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
//time complexity = O(n)
//solution: Dynamic programming algorithm;