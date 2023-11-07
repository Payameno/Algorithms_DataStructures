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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        //Base: Null bst
        if (root == null) return null;

        if (root.val == key) {
            //Case1: Root has no children
            if (root.left == null && root.right == null) return null;

            //Case2: Root only has left child
            if (root.right == null && root.left != null) root = root.left;

            //Case3: Root only has right child
            if (root.left == null && root.right != null) root = root.right;

            //Case4: Root has right & left children
            if (root.left != null && root.right != null) {
                TreeNode node = helper(root, root.right);
                root.val = node.val;
            }
         } else if (key > root.val) {
            //If key is greater than the value of root, it is situated in the right subtree
            root.right = deleteNode(root.right, key);
         } else {
            root.left = deleteNode(root.left, key);
         }
         return root;
    }

    private TreeNode helper(TreeNode parent, TreeNode root) {
        TreeNode pre = parent, cur = root;

        //If root has a left subtree, search for smallest value
        if (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        
        deleteNode(pre, cur.val);
        return cur;
    }
}

/*
 * Time complexity:
 * Worst case where deleted node is a leaf node
 * O(h) where h is the height of BST, in a balanced bst h = logn, however,
 * in a skewed BST(a linear chain of nodes) h = n where n is the number of nodes in the bst
 * 
 * Space complexity:
 * O(h) memory utilization based on the call stack of recursion in helper function
 * In the worse case h = n, in a balanced tree h = logn
 */