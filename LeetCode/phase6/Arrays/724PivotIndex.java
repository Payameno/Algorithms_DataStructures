class Solution {
    public int pivotIndex(int[] nums) {

        int sum = 0;

        //Calculate the sum of all numbers
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0, rightSum = sum;

        //Perform the iteration to find the pivot
        for (int i = 0; i < nums.length; i++) {

            //Pointer on the ith element
            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        //Return -1 if pivot point does not exist
        return -1;

    }
}