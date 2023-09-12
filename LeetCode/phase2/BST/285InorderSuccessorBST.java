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

class solution {

  public TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {

    //Base
    if (root == null) return null;

    //Define pointers
    TreeNode cur = root, pre = null;

    while (cur != null) {

      if (cur.val > p.val) {
        pre = cur;
        cur = cur.left;
      } else {
        cur = cur.right;
      }

    }

    return pre;
  }
}