function search(nums: number[], target: number): number {
  let l=0, r=nums.length-1, m: number;
  while (l <= r) {
    m = Math.floor((l+r)/2);
    if(nums[m] === target ) return m;
    else if (nums[m] > target) r = m-1;
    else l = m+1;
  }
  return -1;
};

// Input: nums = [-1,0,3,5,9,12], target = 9

                    