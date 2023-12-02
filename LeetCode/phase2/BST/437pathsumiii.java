import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int counter = 0;
    int tar;
    public int pathSum(TreeNode root, int targetSum) {
        tar = targetSum;
        //Recursive method to traverse the tree
        dfs(root, new LinkedList<>());

        //Return the value
        return counter;
    }

    private void dfs(TreeNode node, List<Integer> list) {

        //Base
        if (node == null) return;

        //Define current sum
        int curSum = 0;

        //Add the currrent value to the list
        list.add(node.val);

        //iterate backwards to calculate the sum, add to counter if target reached
        for (int i = list.size() - 1; i >= 0; i--) {
            curSum += list.get(i);
            if (curSum == tar) counter++;
        }

        //traverse the left
        dfs(node.left, list);

        //traverse the right
        dfs(node.right, list);

        //backtrack by remove current node value from the list
        list.remove(list.size() - 1);

    }
}

/*
 Time complexity:
 O(N^2) 
 Worst case when the tree is skewed where N is the number nodes in the tree

 Space complexity:
 O(N)
 For recursion call stack in worst case scenario is O(N) which is the height of the tree, 
 LinkedList can also hold N elements, this is not independent from the height of the tree 


Example 1:

        10
       /  \
      5   -3
     / \    \
    3   2   11
   / \   \
  3  -2   1 


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
 */