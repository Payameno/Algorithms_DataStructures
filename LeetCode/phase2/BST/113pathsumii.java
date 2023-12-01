import java.util.*;

import javax.swing.tree.TreeNode;
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

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        findPaths(root,targetSum, 0, new LinkedList<>());
        return res;
    }

    private void findPaths(TreeNode node, int target, int currentSum, List<Integer> currentPath) {
        if (node == null) return;
        currentPath.add(node.val);
        currentSum += node.val;

        //If leaf node reached and target matches the current sum
        if (node.left == null && node.right == null && currentSum == target) {
            res.add(new LinkedList<>(currentPath)); // Added as a copy to the list (avoiding reference clearing)
        } else {
            findPaths(node.left, target, currentSum, currentPath);
            findPaths(node.right, target, currentSum, currentPath);
        }

        //BackTrack
        currentPath.remove(currentPath.size() - 1);
    }

}

/*
 Time complexity:
 O(N) where N is the number of nodes

 Space complexity:
 O(H) the depth of recursion stack
 H  = N worst case - skewed binary tree
 
 Example 1:

        5
       / \
      4   8
     /   / \
    11  13  4
   / \    /  \
  7   2  5    1

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */