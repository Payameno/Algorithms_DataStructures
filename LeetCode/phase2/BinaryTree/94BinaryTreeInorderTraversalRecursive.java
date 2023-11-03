/**
 * Definition for a binary tree node.
 * /**
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

    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        //In-order traversal by recursive approach
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        
        //base
        if (node == null) return;

        //Traverse the left subtree
        dfs(node.left);

        //Add the value of the node
        res.add(node.val);

        //traverse the right subtree
        dfs(node.right);
    }
}

/*
 * Time complexity:
 * O(n) where n is the number of nodes
 * 
 * Space complexity:
 * O(h) where h is the height if the binary tree, in a balanced tree 
 * h = log(n) where n is the number of nodes
 */