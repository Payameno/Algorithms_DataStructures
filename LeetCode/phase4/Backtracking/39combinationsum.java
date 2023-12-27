import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;

        helper(target, 0, new LinkedList<Integer>());
        return res; 
    }

    private void helper(int target,int index, List<Integer> comb) {
        //When target completed
        if (target == 0) {
            List<Integer> temp = new LinkedList<>(comb);
            res.add(temp);
            return;
        }

        //DFS all possible paths
        for (int i = index; i < candidates.length; i++) {
            //Take out the current value
            int curSum = target - candidates[i];
            
            if (curSum < 0) continue;

            //Add the item to the combinatioon
            comb.add(candidates[i]);

            //Recursively take the next possible item in the list
            helper(curSum, i, comb);

            //Backtrack
            comb.remove(comb.size() - 1);
        }
    }

}

/*
 Time complexity:
    N = Number of items in the array of integers
    M = Maximum possible depth for the call stack 
    (Target max = 40, Integer min = 2, therefore M.Max = 20)
    overall:  O(N^(target/min(candidates)))

 Space complexity:
 O(N)
 Factoers that contribute to the space complexity:
 Comb array: O(N) where N is the number of elements in the candidates array, and we can have N comb
 call stack depth :worst case O(20) where target is 40 and min value in the candidates array is 2

 Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */