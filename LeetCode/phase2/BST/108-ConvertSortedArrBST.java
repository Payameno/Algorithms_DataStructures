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

  int[] Nums;

    public TreeNode sortedArrayToBST(int[] nums) {
      
      Nums = nums;
      return buildBST(0, nums.length - 1);

    }

    private TreeNode buildBST(int sIdx, int eIdx) {

      if (sIdx > eIdx) return null;

      int mid = (sIdx + eIdx) / 2;

      //Create the parent node
      TreeNode cur = new TreeNode(Nums[mid]);

      //Build left and right - Balanced height
      cur.left = buildBST(sIdx, mid - 1);
      cur.right = buildBST(mid + 1, eIdx);

      return cur;
      
    }

}

/*

A binary search tree is a tree where nodes are arranged in a way that the left subtree
is always less than the parent and the right right subtree always greater. this rule applies for
nodes in the left and right subtrees as well


 * Input: nums = [-10,-3,0,5,9]
 * Input: nums = [-10,-9,-8,-7,-6,-3,0,5,9]
 * 
 * Time complexity:
 * O(n)
 * In this solution each node is exactly used once to recreate the binary search tree
 * therefore the time complexity is O(n) where n is the number of nodes
 * 
 * Space complexity:
 * O(1)
 * 
 */

