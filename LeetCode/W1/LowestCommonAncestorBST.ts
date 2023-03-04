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

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
  return findLCA(root, p, q);
};

function findLCA(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null) {
  if ([root, p, q].includes(null)) return root;

  if (p.val > root.val && q.val > root.val) return findLCA(root.right, p, q);

  if (p.val < root.val && q.val < root.val) return findLCA(root.left, p, q);

  return root;
}