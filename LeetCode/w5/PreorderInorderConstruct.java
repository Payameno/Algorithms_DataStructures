import java.util.HashMap;

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

public class PreorderInorderConstruct {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i=0; i<inorder.length; i++) map.put(inorder[i], i);

    //recursive call to create the binary tree
    return splitTree(map, preorder, 0, 0, inorder.length-1);
  }

  private TreeNode splitTree(HashMap<Integer, Integer> map, int[] pre, int pix, int leftI, int rightI) {
    int pval = pre[pix];
    TreeNode root = new TreeNode(pval);

    int pixInorder = map.get(pval);

    if (pixInorder > leftI) {
      root.left = splitTree(map, pre, pix+1, leftI, pixInorder-1);
    }

    if(pixInorder < rightI) {
      root.right = splitTree(map, pre, pix+pixInorder-leftI+1 ,pixInorder+1, rightI);
    }

    return root;
  }

}

/*
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */