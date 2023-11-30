import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
    String TN = "X";
    Set<String> visited = new HashSet<>();
    Map<String, TreeNode> duplicates = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return new LinkedList<>(duplicates.values());
    }

    public String postOrderTraversal(TreeNode node) {

        StringBuilder sb = new StringBuilder();
        String leftSubtree = TN, rightSubtree = TN; 

        //Inorder traversal of the left subtree
        if (node.left != null) {
            leftSubtree = postOrderTraversal(node.left);
        }


        //Inorder traversal of the right subtree
        if (node.right != null) {
            rightSubtree = postOrderTraversal(node.right);
        }

        sb.append(node.val);
        sb.append(",");
        
        //InOrder mapping of the subtree (Traversal mapping is arbitrary)
        sb.append(leftSubtree);
        sb.append(",");
        sb.append(rightSubtree);
        sb.append(",");

        String curSubtree = sb.toString();
        checkDuplicate(curSubtree, node);
        return curSubtree;

    }

    private void checkDuplicate(String subTree, TreeNode node) {
        if (visited.contains(subTree)) {
            //if Dulicate, map the node and the string reps(for record)
            duplicates.put(subTree, node);
        } else {
            visited.add(subTree);
        }
    }
}

/*
Time comolexity:
1- Post Order Traversal:
considering N nodes, each node is visited once 0(N)

2-String building:
For each Node, a string is built representing the subtree
Wrost case when the binary tree is skewed, this string for a node would take O(N) time complexity

3-Hashset & HashMap operations:
Add, contains, put methods usually take O(1) constant time complexity, however, since we are working
with strings, the time complexity depends on the length of the string. For the worst case scnario
in a large subtree the time complexity would be O(N)

Overal, O(N^2)
since we are visiting each node, and each node can have a subtree string with a length of N
this would take N squared time complexity


Space complexity:

1- Recursive stack:
O(N) worst case of a skewed binary tree

2-Data structures:
HashSet:
The key consideration is the size and number of unique strings that are stored. 
Each unique subtree representation is stored as a string. In the worst-case scenario, a tree with 
N nodes can have up to N unique subtree representations. 
The length of each string representation of a subtree could be O(N) in the worst case 
(for a skewed tree where the subtree at each node includes all nodes below it). 
Therefore, in a skewed tree, the cumulative space taken by these string representations 
can still approach O(N^2) in the worst case. , considering each unique string could be of length N 
and there could be N such strings.
HashMap:
It can grow no More than O(N) for the worst case of string, the values are only pointers to nodes

3- Output list
The output list of duplicates (Linkedlist) in worst case scnario can take 0(N) space

Overal Space complexity: O(N^2)

----------------------------------

 Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200
 */