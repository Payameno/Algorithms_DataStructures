/*
 class Node {

    int val;
    Node left;
    Node right;

    public Node();

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
 } 

 */

class solution {
    
    Node head = null;
    Node pre = null;

    public Node treeToDoublyList(Node root) {

        //Inorder traversal of the tree
        dfs(root);

        //Link the head and tail
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node root) {

        if (root == null) return;
        
        //Traverse the left subtree
        dfs(root.left);

        //current Node
        if (head == null) {
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;

        //Traverse the right subtree
        dfs(root.right);
    }

}

/*
 Time complexity:
 O(N) where N is the number of Nodes in the tree
 Linear time complexity to the number of nodes

 Space complextiy:
O(H) where H is the height of the tree
Worst case O(N) in a skewed binary search tree

 Example 1:

        4
       / \
      2   5
     / \     
    1   3  

    We want to transform this BST into a circular doubly linked list. Each node 
    in a doubly linked list has a predecessor and successor. For a circular 
    doubly linked list, the predecessor of the first element is the last element,
     and the successor of the last element is the first element.

    Head -> 1 -> 2 -> 3 -> 4 -> 5_ 
          ^ | <-   <-   <-   <- ^|
          | |___________________|| 
          |______________________|

    Specifically, we want to do the transformation in place. After the 
    transformation, the left pointer of the tree node should point to its 
    predecessor, and the right pointer should point to its successor. 
    We should return the pointer to the first element of the linked list.
    <<We do not use a TreeNode class but to transform the binary tree>>

 */