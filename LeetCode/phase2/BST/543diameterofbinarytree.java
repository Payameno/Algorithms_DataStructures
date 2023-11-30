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
    public int diameterOfBinaryTree(TreeNode root) {
       dfs(root);
       return max; 
    }

    private int dfs(TreeNode node) {
        int left = 0, right = 0;

        if (node.left != null) {
            left = dfs(node.left);
        }
        if (node.right != null) {
            right = dfs(node.right);
        }

        //Updates the value of max
        max = Math.max(max, left + right);

        //Updates the path length of current node 
        return Math.max(left,right) + 1;
    }
}

/*
 Time complexity:
 O(N) where N is the number of nodes, all nodes are visited once

 Space Complexity:
 O(H) where H is the height of t he binary tree
 In a balanced tree H = Logn 
 In a skewed binary tree H = N

Example 1:


Input: root = [1,2,3,4,5]
        1
       / \
      2   3
     / \ 
    4  5 

Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */