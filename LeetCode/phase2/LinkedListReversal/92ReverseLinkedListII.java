/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base
        if (head.next == null || left == right) return head;

        //Define the dummy node
        ListNode dummy = new ListNode();
        dummy.next = head;

        //Define pre and cur nodes
        ListNode pre = dummy, cur = head;

        //Move pointers in the position (Beginning of sublist) 1-indexed
        for (int i = 1; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }

        //Find the number of connections in sublist
        int connections = right - left;

        //Traverse the sublist, move nodes behind one at a time
        for (int i = 0; i < connections; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

}

/*
 * Time complexity: 
 * O(n) worse case, 
 * O(m+t) where m is the steps to get to the left border
 * of sublist and t is the connections between sublist nodes
 * 
 * Space complexity: 
 * O(1) - Memory usage does not change over time
 * 
 * Process:
 * (1)
 * null  1 -> 2 -> 3 -> 4 -> 5
 * pre  cur  nex 
 * 
 * (2)
 * 1 -> 2 -> 3 -> 4 -> 5
 * pre cur  nex 
 * 
 * (3)
 * 1 -> 3 -> 2 -> 4 -> 5
 * pre      cur  nex
 * 
 * (4)
 * Result:
 *  1 -> 4 -> 3 -> 2 -> 5
 */