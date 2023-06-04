import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

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

public class BinaryTreeRightSideView {
  List<Integer> listNodes;

  public List<Integer> rightSideView(TreeNode root) {
    listNodes = new ArrayList<>();

    helper(root,0);
    
    return listNodes;
}

  private void helper(TreeNode root,int level) {

    if (root == null) return;
        
    if(level==listNodes.size()) listNodes.add(root.val);

    helper(root.right, level+1);
    helper(root.left, level+1);

  }

}
