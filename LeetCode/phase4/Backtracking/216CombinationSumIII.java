import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1, n, k, new LinkedList<>());
        return res;
    }

    private void helper(int index, int target, int len, List<Integer> comb) {

        //Check of we found a combination
        if (target == 0 && len == 0) {
            List<Integer> temp = new LinkedList<Integer>(comb);
            res.add(temp);
            return;
        }

        //Check if maximum length of comb is reached
        if (len == 0) return;
        
        for (int i = index; i <= 9; i++) {
            int curSum = target - i;

            //Base
            if (curSum < 0) break;

            comb.add(i);

            //Recursion
            helper(i + 1, curSum, len - 1, comb);

            //BackTrack
            comb.remove(comb.size() - 1);
        }
    }

}

/*
Time complexity:
O(9) + O(k) = o(k)

Space complexity:
O(MXK) K the depth of recursion, M the number of combinations


Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 */