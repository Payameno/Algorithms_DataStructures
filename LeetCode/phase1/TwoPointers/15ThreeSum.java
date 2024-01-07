import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> res = new LinkedList<>();

        //Iterate over the nums
        for (int i = 0; i < n - 2; i++) {
            //pointers definition
            int L = i + 1, R = n - 1;

            //Base to avoid re-calculation
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (L < R) {
                int curSum = nums[i] + nums[L] + nums[R];
                if (curSum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) L++;
                    L++;
                    while(L < R && nums[R] == nums[R - 1]) L++;
                    R--;
                } else if (curSum < 0) {
                    L++;
                } else {
                    R--;
                }
            }

        }


        return res;
    }
}

/*
Time complexity:


Space complexity:


Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */