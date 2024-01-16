class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        cache[0] = 1; //Define the bottom value

        //Calculate combinations from the bottom integers
        for (int i = 1; i <= target; i++) {
            
            int curSum = i;
            for (int num : nums) {
                if (curSum -  num >= 0) {
                    cache[curSum] += cache[curSum - num];
                }
            }
        }    
        return cache[target];    
    }

}

/*
Time complexity:
O(n*target)

Space complexity:
O(target)
 */