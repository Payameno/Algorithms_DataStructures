// Given an integer array nums, return all the triplets 
// [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.
// Input: nums = [-1,0,1,2,-1,-4] => sort = nums = [-4,-1,-1,0,1,2]
//                                                             r
//                                                           l
// Input: nums = [-1,-1,1,2,-1,-4]

// Output: [[-1,-1,2],[-1,0,1]]

//Bruteforce: Time complexity of )(n^3)
//sliding window (two pointer) solution with the time complexity of O(n^2)

function threeSum(nums: number[]): number[][] {

  //sort the array to make sliding window approach possible
  nums = nums.sort((a,b) => a-b);
  let result: number[][] = []; //[[], [], []];

  //loop through the array from 0 to arr.length - 2
  //because there should be one element left for L and R to loop through

  for (let i=0; i < nums.length - 2; i++){

    //start from zero or in case of duplicates move one position forward
    if (i === 0 || (i>0 && nums[i] !== nums[i-1])) {
      let left = i + 1;
      let right = nums.length - 1;
  
      // num[2] + num[3] = 0 - num[1]
      let sum = 0 - nums[i];

      while(left < right) {

        if (nums[left]+nums[right] === sum) {

          result.push([nums[i], nums[left], nums[right]]);

          //we should check for duplicates in this loop as well
          while(left<right && nums[left] === nums[left+1]) left++;
          while(left<right && nums[right] === nums[right-1]) right--;

          left++;
          right--;

        } else if (nums[left]+nums[right] < sum) {
          left++;
        } else {
          right--;
        }

      }
    }
  }

  return result;

};