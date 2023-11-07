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
    public boolean isValidBST(TreeNode root) {

        return dfs(root,null,null);
    }

    private boolean dfs(TreeNode root,Integer min,Integer max) {

        //Base
        if (root == null) return true;

        //Conditions that contradict the bst
        if (min != null && root.val <= min) return false;
        if (max != null && max <= root.val) return false;

        //Validate left & right subtrees
        boolean left = dfs(root.left, null, root.val);
        boolean right = dfs(root.right,root.val, null);

        return left && right;

    }
}

/*
 * Time complexity:
 * O(N) where N is the number of nodes
 * 
 * Space complexity:
 * o(h) where h is the height of tree 
 */