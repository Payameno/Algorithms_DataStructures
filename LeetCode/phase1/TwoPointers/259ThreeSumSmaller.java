class solution {
    public int threeSumSmaller(int[] nums, int target) {
                //Sort Array
        Arrays.sort(nums);

        int n = nums.length;
        int counter = 0;

        //Iterate using two pointers
        for (int i = 0; i < n; i++) {
            //Define pointers
            int Left = i + 1, Right = n - 1;

            //Base
            if (i > 0 && nums[i] == nums[i - 1]) continue;

                while (Left < Right) {

                    int curSum = nums[i] + nums[Left] + nums[Right];
                    if (curSum < target) {
                        counter += Right - Left;
                        Left++;
                    } else {
                        Right--;
                    }

            }
        }
        return counter;
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



Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: There are two triplets where sum is smaller than the target
[-2,0,1]
[-2,0,3]
*/