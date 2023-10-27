/*
// Definition for a Node.
class Node {
    public int val;
    public Node prevv;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node prev = null;

        while (node != null) {
            prev = node;
            if (node.child != null) {

                //attach the tail
                Node tail = dfs(node.child);
                tail.next = node.next;
                //Check if the subsequent node exists, then attach it
                if (node.next != null) {
                    node.next.prev = tail;
                }

                //Attach the child to node
                node.next = node.child;
                node.next.prev = node;
                node.child = null;

                //Updating the pointers
                node = tail.next;
                prev = tail;

            } else {
                node = node.next;
            }
        }
        return prev;
    }

}

/*
 * Time Complexity:
 * O(n) where is the number of nodes in the doubly linkedlist
 * Space Complexity:
 * O(1) constant memory
 */