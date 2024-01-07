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