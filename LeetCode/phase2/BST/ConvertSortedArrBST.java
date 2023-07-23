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

      TreeNode cur = new TreeNode(Nums[mid]);

      //Build left and right - Balanced height
      cur.left = buildBST(sIdx, mid - 1);
      cur.right = buildBST(mid + 1, eIdx);

      return cur;
      
    }

}

/*
 * Input: nums = [-10,-3,0,5,9]
 * Input: nums = [-10,-9,-8,-7,-6,-3,0,5,9]
 */

