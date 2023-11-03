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
    public ListNode rotateRight(ListNode head, int k) { 

        //Base
        if (k == 0 || head == null || head.next == null) return head;

        //Create a circular LL, also find the size
        ListNode cur = head, pre = null;
        int size = 0;
        while (cur != null) {
            size++;
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;

        //Rotate the linkedlist
        k = k % size;
        int rotate = size - k;
        
        //Reset Cur
        cur = null;
        for (int i = 0; i < rotate;i++) {
            cur = head;
            head = head.next;
        }
        cur.next = null;
        return head;
    }
}

/*
 * Time complexity:
 * 
 * Space complexity:
 * 
 * Approach:
 * 
 * Example: 1 -> 2 -> 3 -> 4 -> 5
 * 1) create a circular LinkedList by connecting last node to the first
 * 2) find the size of the list
 * 3) check if K is a multiple of size, List will not be rotated
 * 4) find the head node after rotation, link previous node to null
 * 5) return the head node
 * 
 */