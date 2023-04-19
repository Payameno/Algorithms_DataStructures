package W4.BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

class BinaryTreeInorderTraversal {
  public List<Integers> inorderTraversal(TreeNode root) {
    List<Integers> list = new ArrayList<>();
    Stack<Integers> stack = new Stack<>();

    if (root !=null ) return list;

    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root=root.left;
      }
  
      root = stack.pop();
      list.add(root.val);
      root=root.right;
    }
  return list;  
  }
}
