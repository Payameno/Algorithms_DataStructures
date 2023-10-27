class Solution {
    public int search(int[] nums, int target) {

        //Define the pointers
        int L = 0, R = nums.length - 1;

        while (L + 1 < R) {
            int M = (L + R) / 2;

            //Devide to two sorted segments
            if (nums[M] > nums[L]) {

                //Check if the target is at the left side
                if (target >= nums[L] && target <= nums[M]) {
                    R = M;
                } else {
                    L = M;
                }

            } else {

                if (target >= nums[M] &&  target <= nums[R]) {
                    L = M;
                } else {
                    R = M;
                }

            }
        }
        if (nums[L] == target) return L;
        if (nums[R] == target) return R;

        return -1;
    }
}

/*
Time complexity:
O(logn) found using binary search approach

Space complexity:
O(1) constant

Description:
Devide the array into two segments of sorted integers
find which half the target belongs to, move pointers to reach the target



 * Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 1
                       L
                         M
                         R   

Output: 4
>>>>>>>>>>
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

>>>>>>>>>>
Example 3:

Input: nums = [5,6,7,8,0,1,2,3,4], target = 3
               L
                       M
                            R 
Output: 6
 */