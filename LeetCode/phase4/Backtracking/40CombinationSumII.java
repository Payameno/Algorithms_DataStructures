import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

            //To avoid duplicate results, sorted array's repeated items are skipped
            if (i != index && candidates[i] == candidates[i - 1]) continue;

            //Take out the current value
            int curSum = target - candidates[i];
            
            if (curSum < 0) continue;

            //Add the item to the combinatioon
            comb.add(candidates[i]);

            //Recursively take the next possible item in the list
            helper(curSum, i + 1, comb);

            //Backtrack
            comb.remove(comb.size() - 1);
        }
    }

}

/*
 * Time complexity:
 * O(N log N)
 * -where N is the number of elements in the candidates array
 * -Also O(N^K) All possible combinations of elements are explored
 * -K is the maximum depth of the recursion which is the length of a possible
 * combination
 * Overal the time complexity is dominated by O(NlogN)
 * 
 * Space complexity:
 * O(K) the Auxiliary space used for the depth of call stack and length of comb
 * + O(M) space required for M combinations added to the res list
 * 
 * 
 * Note: Solution does not result in an out of bound i because of having 
 * two conditions in place, 1) if target == 0 2) if sum < 0

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

 */