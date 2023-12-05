import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

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

    //Global index variable
    int index = 0;
    int[] pre, post;
    HashMap<Integer,Integer> hm = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pre = preorder;
        post = postorder;

        //Map values of the postOrder array to their index
        for (int i = 0; i < postorder.length; i++) {
          hm.put(postorder[i], i);
        }

        return dfs(post.length);
    }

    private TreeNode dfs(int preIdx) {

      //Base 
      if (index >= pre.length) return null;

      int curVal = pre[index];
      
      //Find the index in the postOrder array
      int curIdx = hm.get(curVal);
      
      //Make sure current node is children of the parent
      if (preIdx < curIdx) return null;

      //Build the node
      TreeNode root = new TreeNode(curVal);
      index++;

      //Reconstruct the left subtree
      root.left = dfs(curIdx);

      //Rec the right subtree
      root.right = dfs(curIdx);

      return root;
    }

}

/*
Reconstructing a binary tree from traversal strategies:
while it's possible to attempt reconstruction with only the pre-order traversal,
it may not be sufficient to guarantee a unique reconstruction. If you have access
to the in-order/post-order traversal as well, you can more reliably reconstruct 
the original binary tree.

We know that the first element in the preOrder array is the root
The children of this element always appeare before it in the postOrder array
Using these two facts, we can approach to build an algorithm to re-build this
Binary tree.


 Time complexity:

 O(N) where N is the number of nodes in the tree
 Mapping N postOrder array values to their index in the hashmap
 + recursion call stack to visit and reconstruct the nodes
Functions in this method have a constant time complexity

 Space complexity:
 
 O(N) Space occupied by HashMap & call stack (worst case in a skewed binary tree) 

Example 1:

          1 
        /   \
       2     3 
      /  \  /  \
     4   5  6   7

Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
                         ^
Output: [1,2,3,4,5,6,7]


Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]
 

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
 */