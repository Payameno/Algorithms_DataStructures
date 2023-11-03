import java.util.Stack;

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
    List<Integer> resRec = new LinkedList<>();

    public List<Integer> postorderTraversalIterativeFirst(TreeNode root) {

        /*
         * The first solution is to add each node to the beggining of res
         */

        //Create a list for the result
        List<Integer> resIte = new LinkedList<>();

        //Base
        if (root == null) return res;

        //Stack for Iterative traversal
        Stack<TreeNode> stack = new stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(0,top.val);
            if (top.left != null) stack.add(top.left);
            if (top.right != null) stack.add(top.right);
        }

        return res;

    }

    public List<Integer> postorderTraversalIterativeSecond(TreeNode root) {

        /*
         * Second approach recursively add left and right subtrees
         * 
         */
    //Create a list for the result
    List<Integer> resIte = new LinkedList<>();

    //Base
    if (root == null) return res;

    //Stack for Iterative traversal
    Stack<TreeNode> stack = new stack();
    stack.add(root);

    while (!stack.isEmpty()) {
        TreeNode top = stack.peek();
        if (top.left == null && top.right == null) {
            res.add(top.val);
            stack.pop(top);
        } else {
            if (top.right != null) {
                stack.add(top.right);
                top.right = null;
            }
            if (top.left != null) {
                stack.add(top.left);
                top.left = null;
            }
            /*
             * We need to set top.left and top.right as null for the first if statement to get into work
             * This way we rely solely on the stack to keep track of the order
             */
        }
    }

    }

    public List<Integer> postorderTraversalIterativeThird(TreeNode root) {
     
    //Create a list for the result
    List<Integer> resIte = new LinkedList<>();

    //Base
    if (root == null) return resIte;

    //Stack for Iterative traversal
    Stack<TreeNode> stack = new Stack();
    TreeNode cur = root, pre = null;

        while (cur != null || !stack.isEmpty()) {

            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.peek();
                //pre keeps track of the case when there is a sole right node to a parent node
                //the code will eventually add it to the res, and we want to make sure not to add it twice
                if (top.right == null || top.right == pre) {
                    resIte.add(top.val);
                    stack.pop();
                    pre = top;
                    cur = null; //Set as null to retrieve last in stack
                } else {
                    cur = top.right;
                }
            }
        }
        return resIte;   
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return resRec;
    }

    private void dfs(Treenode root) {

        if (root == null) return;

        //Recursively traverse left nodes
        dfs(root.left);

        //Recursively traverse right nodes
        dfs(root.right);

        //Add the current value
        res.add(root.val);
    }
}

/*
Post-Order traversal: In post order traversal, first left subtree is recursi vely traversed,
After that the right subtree is recursively traversed and finally the cur node is visited.
 * 
 * Recursive approach
 * Time complexity:
 * O(n) where n is the number of nodes in the binary tree
 * 
 * Space complexity:
 * o(h) where h is the height of the binary tree
 * in a balanced binary tree h = log(n)
 * 
 * 
 * 
 * Iterative Approach
 * Time complexity:
 * O(n) where n is the number of nodes in the binary tree
 * 
 * Space complexity:
 * o(h) where h is the height of the binary tree
 * in a balanced binary tree h = log(n)
 * 
 */