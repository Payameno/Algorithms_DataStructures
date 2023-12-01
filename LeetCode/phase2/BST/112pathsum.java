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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int target) {

        target -= node.val;

        //Leaf node target sum evaliation
        if (node.left == null && node.right == null) return target == 0;

        boolean left = false, right = false;
        if (node.left != null) left = dfs(node.left, target);
        if (node.right != null) right = dfs(node.right, target);

        return left || right;
    }
}

/*
 Time comlexity:
 Worst case O(N) (skewed binary tree)

 Space complexity:
 Recursive call stack length O(H)
 H = logN in a blanaced tree
 H = N in a skewed tree


 Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22

        5
       / \
      4   8
     /   / \
    11  13  4
   / \       \
  7   2       1

Output: true - > 5 - 4 - 11 - 2y
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */