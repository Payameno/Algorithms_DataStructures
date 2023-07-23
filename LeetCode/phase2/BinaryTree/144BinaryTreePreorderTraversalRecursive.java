import java.util.List;

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

  //Define result list
  List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

      //Helper function to traverse in pre-order and add the results
      helper(root);
      return res;

    }

    private void helper(TreeNode root) {

      if (root == null) return;

      res.add(root.val);
      
      //recursive approach
      helper(root.left);
      helper(root.right);

    }

}

/*
Time complexity O(n) where n = number of nodes
Space complexity O(h) where h = the height of the tree
   Binary Tree:
        1
       / \
      2   3
     / \ / \
    4  5 6  7

Pre-order Traversal: 1 -> 2 -> 4 -> 5 -> 3 -> 6 -> 7
 */