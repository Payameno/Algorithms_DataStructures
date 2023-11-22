package LinkedList;

class Solution {

    public Node insert(Node head, int insertVal) {

        Node insertNode = new Node(insertVal);

        //Base
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }

        //Define a pointer
        Node cur = head;

        while (cur != head) {

            int curVal = cur.val, nextVal = cur.next.val;

            if (curVal > nextVal) {

                //If Value of inserted node is smaller than cur & nex, ex: 0
                if (curVal > insertNode.val && nextVal > insertNode.val) break;

                //If value of inserted node is larger than cur & nex, ex: 6
                if (curVal < insertNode.val && nextVal < insertNode.val) break;
            }

            //When the Node is positioned between cur and next nodes
            if (curVal < insertNode.val && nextVal > insertNode.val) break;

            cur = cur.next;
        }

        //Insert the node
        Node nex = cur.next;
        cur.next = insertNode;
        insertNode.next = nex;

        return head;
    }

}

/*

Example one:
Circular linked list:  .. 3 -> 4 -> 1 ..
                          next       cur   
Insertval = 2

Example two: ..., 4, 5,   1, 2, ...
                    cur next
InsertVal = 0 or 6

Insert into a Cyclic Sorted List

Given a node from a cyclic linked list which is sorted in ascending order, 
write a function to insert a value into the list such that it remains a cyclic 
sorted list. The given node can be a reference to any single node in the list, 
and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place 
to insert the new value. After the insertion, the cyclic list should remain 
sorted.

If the list is empty (i.e., given node is null), you should create a new single 
cyclic list and return the reference to that single node. Otherwise, you should 
return the original given node.

https://leetcode.ca/all/708.html

 */