package W4.BinarySearchTree;

import javax.swing.tree.TreeNode;

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

class ValidateBTS-Recursive {

  TreeNode prev = null;

  public boolean isValidBST(TreeNode root) {

    if (root == null) return true;

    if (isValidBTS(root.left) == false) return false;

    //indicate the condition to evaluate BTS
    if (prev.val != null && prev.val >= root.val) return false;
    prev = root;

    if (isValidBTS(root.right == false)) return false;

    //Set this node as the previous

    return true;
  }
}
