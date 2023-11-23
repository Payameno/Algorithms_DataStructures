package LinkedList;

import java.util.HashMap;

import org.w3c.dom.Node;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        //Base Case
        if (head == null) return null;

        //Define a table, mapping Node to it's deep clone
        Map<Node,Node> hm = new HashMap<>();

        //Define a pointer
        Node cur = head;
        hm.put(cur, new Node(cur.val));

        //Loop through singly-LinkedList and generate a deep copy
        while (cur != null) {

            //Create the Deep Copy Node
            Node curDeepCopy = hm.get(cur);

            //Evaluate cur.randon, check presence both in node or map (to avoid duplicate puts)
            if (cur.random != null && !hm.containsKey(cur.random)) {
                hm.put(cur.random, new Node(cur.random.val));
            }

            //Create the random node
            Node randomDC = hm.get(cur.random);
            //Point the node's deep copy to the random node (either a node or null)
            curDeepCopy.random = randomDC;

            //Evaluate cur.next
            if (cur.next != null && !hm.containsKey(cur.next)) {
                hm.put(cur.next, new Node(cur.next.val));
            }

            //Create the next node
            Node nextDC = hm.get(cur.next);
            curDeepCopy.next = nextDC;

            cur = cur.next;
        }
        return hm.get(head);
    }
}

/*
Solution:
Using a Table to create different segments of a Node, finally putting them together

Time complexity:
O(N) where N is the number of nodes in the linkedlist

Space complexity:
O(N) as the HashMap maps nodes to their clone

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.

 */