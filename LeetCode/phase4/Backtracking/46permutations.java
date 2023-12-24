import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new LinkedList();

        for (int num : nums) {
            list.add(num); //Add each unqie integer, used as a path
        }

        helper(list, new LinkedList());

        return res;
    }

    private void helper(List<Integer> list, List<Integer> curComb) {
        //If list empty
        if (list.isEmpty()) {
            List<Integer> temp = new LinkedList<>(curComb);
            res.add(temp);
            return;
        }

        //Each integer in the list is a path
        for (int i = 0; i < list.size(); i++) {
            int val = list.remove(i);
            curComb.add(val);
            helper(list,curComb);

            //Reverse last changes in the curComb and list
            curComb.remove(curComb.size() - 1);
            list.add(i,val); // index must be stated
        }
    }

}

/*
Time complexity:
O(N X N!)

 N: Number of elements in the nums
 Helper function
 For each item the loop iterates:
 N for for the first item
 N-1 for the second
 N-2 for the third
 ... Therefore n! n factorial times

At each iteration we have a recursive call too, which at each level removes
an item, This recursive call has a depth of N.
Creation of list in the Permuate method also takes O(N) time complexity
Therefore the overal time complexity is N x N!


 Space complexity:
O(N)
The depth of the recursion stack

 Solution:
           Recur level      List
              (0) [1,2,3]
              (1) [2,3]
                   ^
              (2) [3]
              (3) []
              (4) [3]
              (5) [2,3]
                     ^

                     Path1           Path2         Path3
             *         1               2            3
             *        / \             / \          / \
             *       2   3           1   3        1   2
             *      /     \         /     \      /     \
             *     3       2       3       1    2       3
             * 
             * 3 paths and 6 combinations

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */