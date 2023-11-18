class solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int right = 0, left = 0, n = nums.length;
        int maxLen = 0, zeroCounter = 0;

        while(right < n) {

            if (nums[right] == 0) {
                zeroCounter++;
            }

            //If the count of zeros larger than 1, shrink the window
            while (zeroCounter > 1) {
                //it will post increment whether or not true
                if (nums[left++] == 0) {
                    zeroCounter--;
                }
            }

            //Count the number of consecutive ones
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
}

/*
Time complexity:
O(n) is linear. where n is the number of elements in the array

Space complexity:
O(1) constant

 * Problem:
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one zero 0.
 * 
 * Input: [1,0,1,1,0]
 *        [1,0,1,1,0]
 *                 R
 *             L
 * zeroCounter = 1;
 * len = 4
 * 
 * Output: 4
 * Explanation: Fliping (changing to 1) the first zero will give the 
 * maximum number of consecutive 1s, After flipping the maximum 
 * number of consecutive 1s is 4.
 */