public class 416partitionequalsubsetsumBottomUp {
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int half = sum/2;

        //Memoization
        boolean[][] cache = new boolean[nums.length][half + 1];
            
        //First column (0 sum) means we have consumed sum using our nums(true)
        for (int row = 0; row < nums.length; row++) {
            cache[row][0] = true;
        }

        //Write the values of the first row
        for (int curSum = 1; curSum < half + 1; curSum++) {
            if (nums[0] == curSum) {
                cache[0][curSum] = true;
            } else {
                cache[0][curSum] = false;
            }
        }

        // Write the remainder of of values
        for (int curNumIdx = 1; curNumIdx < nums.length; curNumIdx++) {
            for (int curSum = 1; curSum <= half; curSum++) {
                int diff = curSum - nums[curNumIdx];

                boolean take = false;
                if (0 <= diff) {
                    take = cache[curNumIdx - 1][diff];
                }
                boolean skip = cache[curNumIdx - 1][curSum];

                cache[curNumIdx][curSum] = take || skip;
            }
        }
        return cache[nums.length - 1][half];
    }

}


/*
 Time complexity:
 O(n*half)

 Space complexity:
o(n*half)

 Sum = 22
 half = 11


Example 1:
Input: nums = [1,5,11,5]
                 ^
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100 
 */