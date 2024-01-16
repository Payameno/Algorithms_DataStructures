class Solution {
    
    int[] nums;
    Integer[] cache;
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.cache = new Integer[target + 1];
        return helper(target);
    }

    private int helper(int curSum) {
        //Base
        if (curSum < 0) return 0; //No combinations could be made
        if (curSum == 0) return 1;
        
        //Use cache
        if (cache[curSum] != null) return cache[curSum];
        
        int total = 0;//saves number of possible combination down a path
        for (int num : nums) {
            total += helper(curSum - num);
        }
        
        cache[curSum] = total; // Save to cache
        return total;
    }
}

/*
 Time complexity:
 O(n*t) worst case, where n is the integers from 0 to the target and t the integers 
 in the nums that can be a combination to create the target
  
 Space complexity:
 Overal O(target)
Two influencing factors are the cache and the depth of the call stack
Cache auxiliary space = O(target + 1)
Call stack depth = O(target) worst case

 */