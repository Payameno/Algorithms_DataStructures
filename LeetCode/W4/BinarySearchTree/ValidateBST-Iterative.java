package W4.BinarySearchTree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

class ValidateBTS-Iterative {

//inorder traversal

  public boolean isValidBST(TreeNode root) {

    if(root == null) return true;

    TreeNode prev = null;
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty()) {

      while(root != null) {
        stack.push(root);
        root = root.left;
      }
  
      root = stack.pop();
      if (prev != null && root.val <= prev.val) return false;
      prev=root;
      root = root.right;
    }

    return true;
  }  
}