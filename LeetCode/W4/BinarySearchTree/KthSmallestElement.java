package W4.BinarySearchTree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

class KthSmallestElement {
  //inorder traversal - iterative approach

  public int kthSnallest(TreeNode root, int kth) {

    Stack<TreeNode> stack = new Stack<>();

    while (root !=null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root=root.left;
       }
   
       root=stack.pop();
       if (--kth==0) break;
       root=root.right;
    }
    return root.val;
  }
}
