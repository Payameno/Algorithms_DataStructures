import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList();
    int[] arr;
    public List<List<Integer>> subsets(int[] nums) {
        this.arr = nums;
        helper(0, new LinkedList<>());
        return res;
    }

    private void helper(int index, List<Integer> comb) {

        res.add(new LinkedList<>(comb));

        for (int i = index; i < arr.length; i++) {
            comb.add(arr[i]);

            helper(i + 1, comb);

            //Backtrack
            comb.remove(comb.size() - 1);
        }
    }

}

/*
 Time complexity:
 Iteration over items O(2^N)
 For each element in the array, there are two choices:
 Include the current element or exclude it
 
 Space complexity:
 Recursion stack O(N), at each level of the recursion stack a new item is added to the comb
 there is also a space required for res, but the auiliary space is predominantely determined by
 the recursion stack


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


Example 2:
Input: nums = [0]
Output: [[],[0]]
 

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

 */