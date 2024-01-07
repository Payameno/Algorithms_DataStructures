class solution {

    public int threeSumClosest(int[] nums, int target) {
        //Sort Array
        Arrays.sort(nums);

        int n = nums.length;
        int gap = Integer.MAX_VALUE, ans = 0;

        //Iterate using two pointers
        for (int i = 0; i < n - 1; i++) {
            //Define pointers
            int Left = i + 1, Right = n - 1;

            //Base
            if (i > 0 && nums[i] == nums[i - 1]) continue;

                while (Left < Right) {

                    int curSum = nums[i] + nums[Left] + nums[Right];
                    if (curSum == target) {
                        return target;
                    } else if (curSum > target) {
                        Right--;
                    } else {
                        Left++;
                    }

                    //Calculate current gap
                    int curGap = Math.abs(curSum - target);
                    //Evaluate current gap
                    if (curGap < gap) {
                        gap = curGap;
                        ans = curSum;
                    }
            }
        }
        return ans;
    }
    
}

/*
    Solution approach: Two pointers

Time complexity:
Sorting the nums array = n*logn
C-type loop = n, while loop = n total of n^2
Overall = BigO(n^2) in worse case scenario

Space complexity:
O(1)
The sorting space does not contribute to any additional space required


Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/