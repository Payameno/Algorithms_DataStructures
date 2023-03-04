/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function isBalanced(root: TreeNode | null): boolean {
  let answer = { isBalanced: true };
  getDepth(root, answer);
  return answer.isBalanced;
};

function getDepth(_root: TreeNode | null, _answer) {
  if (!_root) return false;

  let leftDepth = getDepth(_root.left, _answer);
  let rightDepth = getDepth(_root.right, _answer);

  if (Math.abs(leftDepth - rightDepth) > 1) {
    _answer.isBalanced = false;
  }

  return Math.max(leftDepth + 1, rightDepth +1);
}