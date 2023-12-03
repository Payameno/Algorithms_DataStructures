import java.util.*;

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
    int counter = 0;
    int tar;

    public int pathSumSolution1(TreeNode root, int targetSum) {
        tar = targetSum;
        //Recursive method to traverse the tree
        S1dfs(root, new LinkedList<>());

        //Return the value
        return counter;
    }

    private void S1dfs(TreeNode node, List<Integer> list) {

        //Base
        if (node == null) return;

        //Define current sum
        int curSum = 0;

        //Add the currrent value to the list
        list.add(node.val);

        //iterate backwards to calculate the sum, add to counter if target reached
        for (int i = list.size() - 1; i >= 0; i--) {
            curSum += list.get(i);
            if (curSum == tar) counter++;
        }

        //traverse the left
        dfs(node.left, list);

        //traverse the right
        dfs(node.right, list);

        //backtrack by remove current node value from the list
        list.remove(list.size() - 1);

    }

    HashMap<Integer, Integer> hm = new HashMap<>();

    public int pathSumSolution2(TreeNode root, int targetSum) {
        tar = targetSum;
        hm.put(0, 1);
        S2dfs(root,0);
        return counter;
    }

    private void S2dfs(TreeNode node, int curSum) {

        //Base case
        if (node == null) return;

        //Add current value to the sum
        curSum += node.val;

        //Check if curSum - tar exists in the map
        if (hm.containsKey(curSum - tar)) {
            counter += hm.get(curSum - tar);
        }

        //Update the table with our current sum
        hm.put(curSum, hm.getOrDefault(curSum, 0) + 1);

        //Traverse the left subtree
        S2dfs(node.left, curSum);

        //Traverse the right subtree
        S2dfs(node.right, curSum);

        //Backtrack removal of the curSum
        if (hm.get(curSum) == 1) {
            hm.remove(curSum);
        } else {
            hm.put(curSum, hm.get(curSum) - 1);
        }
    }
}

/*
 Time complexity:

 S1: 
 O(N^2) 
 Worst case when the tree is skewed where N is the number nodes in the tree

 S2:
O(N)
Every node is visisted once, in this one we do not have an iteration to add to the tc

 Space complexity:
 O(N) the height of the call stack in the worst case scnario and the HashMap  N entries
 
 S1: 
 O(N)
 For recursion call stack in worst case scenario is O(N) which is the height of the tree, 
 LinkedList can also hold N elements, this is not independent from the height of the tree 

 S2:
 0(N)

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3

        10
       /  \
      5   -3
     / \    \
    3   2   11
   / \   \
  3  -2   1 

Solution 2 explanation: 

  Get the current sum, map it. along the way take away the target, if through the path 
  current sum minus target equals to one of the mapped amounts this means somewhere in the path
  the sum of nodes equals to the target. therefore there we increment the counter by one.

  Map curSum - tar  /          counter  /   HM
  {10-8=2}  2                    0  (curSum)10 - 1    
  {15-8=7}  7                    0        15 - 1    
 {18-8=10} 10 -HM->              1        18 - 1    
            13                   1        21 - 1 -> BackTrack Removal
 Rleaf      8                    1        16 - 1
                    ( Node with val = -2) B R, {8} removed from the map   
                    (Node with val = 3) B R, {10} removed from the map   
            9                    1        17 - 1
 {(10+5+2+1)-8=10} 10 -HM->      2        18 - 1 
                    (Node with val = 5) B R
            -1                            7 - 1
            10 -HM->           < 3 >
            B R
            B R
            Return counter = 3

Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000

 */