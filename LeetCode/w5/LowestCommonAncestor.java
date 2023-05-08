/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * (least common ancestor) of two nodes v and w in a tree or 
 * directed acyclic graph (DAG) T is the lowest (i.e. deepest) 
 * node that has both v and w as descendants, 
 * where we define each node to be a descendant of itself
 * 
 * 
 * This code follows a depth first approach
 */

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
      if (root == null || root == p || root == q) {
        return root;
      }
    
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left == null) {
        return right;
      } else if (right == null) {
        return left;
      } else {
        return root;
      }

  }
}

/*
Time complexity : 
recursive: worst case O(n) as the recursive
function will visit every node in the tree. That's when p and q are farthest
nodes in the tree.
Best case: O(1) where root is either null,p or q

Memory complexity: O(h) where h is the height of the binary tree
Each recursive call creates a new stack frame which takes up memory space
The maximum number of stack frames created during the recursion is equal to 
the height of the binary tree.

worst case: where binary tree is a skewed tree (all nodes either right or left)
in this case O(n)
*/ 