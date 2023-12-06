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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //Base case
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode node) {
        
        //Base
        if (node == null) return 0;

        /*
         * Recursively traverse left and right subtrees
         * Negative results will be negleted and counted as zero
         */
        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        //Evaluate max
        max = Math.max(max, (leftSum + rightSum) + node.val);

        //The larger child node(subtree) plus current node
        return Math.max(leftSum, rightSum) + node.val;
    }

}

/*
 * Solution approach:
 *  Recursively traverse the binary tree using a method that returns int
 *  if passed the leaf node return 0,
 *  Subtres down to top will return the max path (either right or left) + current node
 * 
 *  Max value is calculated along the way  
 * 
 Time complexity:
 O(N) where N the number of nodes in the binary tree
 Every Node in the binary tree is visited during the depth-first search
 to calculated the subtree sum

 Space complexity:
 O(H) where H is the height of the binary tree and the depth of the call stack
 Worst case O(N) where N is the number of nodes 


 Example 1:

        5
       / \
      2   3

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.


Example 2:

       -10
       / \
      9   20
          / \
         15  7

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
 */