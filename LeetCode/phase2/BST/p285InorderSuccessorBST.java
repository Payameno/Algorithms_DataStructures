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

/*

Problem: 

Given a binary search tree and a node in it, you're asked to find the in-order successor of 
that node in the BST. The in-order successor of a node in a BST is the node that appears 
immediately after the given node in the in-order traversal of the tree. 

Note that if the given node has no in-order successor in the tree, your function should return null.
The problem may also specify that the given node will not be the last node in the tree's 
in-order traversal and that each node will have a unique value.

Here's an example to illustrate:

If the given node's value is x, the in-order successor is the node with the smallest value 
that is larger than x.

Consider the following BST:

    2
   / \
  1   3

The in-order traversal of this tree is 1, 2, 3.
The in-order successor of node 1 is node 2.
The in-order successor of node 2 is node 3.
Node 3 does not have an in-order successor in this tree (so in this case, null would be 
returned).


Time complexity of the solution:
O(h) where h is the height of the tree

Space complexityL
O(1)
 */