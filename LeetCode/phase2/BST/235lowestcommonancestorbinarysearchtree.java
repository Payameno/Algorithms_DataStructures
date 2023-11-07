/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val), max = Math.max(p.val,q.val);
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > min && cur.val > max) {
                cur = root.left;
            } else if (cur.val < min && cur.val < max) {
                cur = root.right;
            } else {
                break;
            }
        }

        return cur;
    }
}

/*
 * Solution Approach:
 * Considering a binary search tree, starting from the root
 * if p and q are both smaller or larger than the root that 
 * means p and q are located, respectively, at the left or right subtree
 * we continue until this is not the case, then the root (parent) node would be
 * the lowest common ancestor
 * 
 * Time complexity:
 * O(h) 
 * We traverse the bst from the root, The time complexity will equal the height 
 * of the tree. When the binary tree is not balanced and skewed this height can
 * equal N which is the number of nodes. In a balanced bst it is  equal to logn
 * 
 * 
 * Space complexity:
 * O(1)
 */