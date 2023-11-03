import java.util.List;

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
class Solution4 {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();

        //Base Case
        if (root == null) return res;

        //Iterative traversal of the binary tree
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            
            if (cur == null) {
                TreeNode top = stack.pop();
                res.add(top.val);
                cur = top.right;
            } else {
                stack.add(cur);
                cur = cur.left;
            }
        }

        return res;    
    }

}

/*

 * Iteretive inorder binary tree traversal
 * 
 * Time complexity: O(n) 
 * 
 * Space complexity: O(h) where h is the height of the binary tree
 * worse case in the case of a linkedList o(n)
 */