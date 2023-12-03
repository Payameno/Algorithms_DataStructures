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

    final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;
        return dfs(root) != UNBALANCED;
    }

    private int dfs(TreeNode node) {
        //Base - Leaf reached, therefore balanced
        if (node.left == null && node.right == null) return 0;
        
        //Define heights
        int leftH = 0, rightH = 0;

        //Traverse the left subtree
        if (node.left != null) {
            leftH = dfs(node.left);
        }
        //At any point if the H difference surpasses 1 return false
        if (leftH == UNBALANCED) return UNBALANCED;

        //Traverse the right subtree
        if (node.right != null) {
            rightH = dfs(node.right);
        }
        if (rightH == UNBALANCED) return UNBALANCED;

        /*
         For current node if the height difference is no more than 1 return
         the max height from this position
         */
        if ((leftH - rightH) <= 1) return Math.max(leftH, rightH) + 1;
        return UNBALANCED;
    }
}

/*
 Time complexity:
 O(N) where N is the number of nodes
 Where there is a balanced tree, all nodes are visited without an exception thrown


 Space complexity:
O(H) call stack height, where H = Logn as the tree is balanced

 Example 1:

         3    L = 2 R = 1
        / \
       9   20   L = 1 R = 1
          /  \
         7   15   

Input: root = [3,9,20,null,null,15,7]
Output: true


Example 2:

        L = 3 R = 1             1 -> dfs returns UNBALANCED
                               / \
        L = 2 R = 1           2   2
                             / \
        L = 1 R = 1         3   3  
                           / \ 
                          4   4

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */