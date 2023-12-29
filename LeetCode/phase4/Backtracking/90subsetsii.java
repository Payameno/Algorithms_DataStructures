import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList();
    int[] arr;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.arr = nums;
        helper(0, new LinkedList<>());
        return res;
    }

    private void helper(int index, List<Integer> comb) {
        
        res.add(new LinkedList<>(comb));
        
        for (int i = index; i < arr.length; i++) {
            //Base (avoid duplicates)
            if (i != index && arr[i] == arr[i - 1]) continue;

            comb.add(arr[i]);

            helper(i + 1, comb);

            //Backtrack
            comb.remove(comb.size() - 1);
        }
    }
}

/*
 * Time complexity:
 * Sorting nums O(NlogN)
 * Worst case when there are no duplicates O(2^N) as the helper
 * function iterates over elements and chooses and excludes the item
 * Overal: O(2^N)
 * 
 * Space complexity:
O(N) which is the maximum depth of the recursion call stack
There is also auxiliary space used by the comb and res arrays but the dominante
factor remains the depth of the recursion call

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */