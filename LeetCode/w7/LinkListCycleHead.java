/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
    
      //base case
      if (head == null || head.next == null) return null;

      //find if there is a cycle
      ListNode slow = head, fast = head;

      while (fast != null && fast.next != null) {

        fast = fast.next.next;
        slow = slow.next;

        if (slow == fast) {

          //find the length of the cycle
          int len = findLen(slow);

          //find the cycle head
          return findCycleHead(len, head);
        }

      }
      return null;
    }

    private int findLen (ListNode node) {

      ListNode temp = node.next;
      int size = 1;

      while (temp != node) {
        temp = temp.next;
        size++;
      }

      return size;
    }

    private ListNode findCycleHead (int len, ListNode head) {
      
      //define two points
      ListNode p1 = head, p2 = head;

      for (int i=0; i<len; i++) {
        p2 = p2.next;
      }

      while (p1 != p2) {
       p1 = p1.next;
       p2 = p2.next;
      }

      return p1;
    }

}