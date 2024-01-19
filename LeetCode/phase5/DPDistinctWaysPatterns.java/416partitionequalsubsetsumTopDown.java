class Solution {

    int[] arr;
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        arr = nums;
        int sum = 0;
        int half = sum / 2;

        cache = new Boolean[arr.length][half + 1];
        //Calculate the sum of all integers in the nums
        for (int num : nums) {
            sum += num;
        }

        //Base - check if the sum's half can be a real number
        if (sum % 2 != 0) return false;

        return helper (half, 0);
    }

    private boolean helper(int sum, int index) {

        //Base
        if (sum < 0 || arr.length <= index) return false;
        if (sum == 0) return true;

        if (cache[index][sum] != null) {
            return cache[index][sum];
        }
 
        boolean take = helper(sum - arr[index], index + 1);
        boolean skip = helper(sum, index + 1);

        return cache[index][sum] = take || skip; 

    }

}

/*
 Time complexity:
O(n*half)
worst case where n the number elements and half is sum/2 (where all made by 1s)

 Space complexity:
O(n* half)
Cache is the contributor


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