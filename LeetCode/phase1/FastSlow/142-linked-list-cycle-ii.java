import java.util.*;

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
class Solution {

    public ListNode detectCycle(ListNode head) {

     //base
      if (head == null || head.next == null) return null;

      //Define fast and slow pointers
      ListNode slow = head, fast = head, cycleHead = null;
      int size = 0;

      //Traverse the list, evaluate a cycle
      while (fast != null && fast.next != null) {


        slow = slow.next;
        fast = fast.next.next;

        if (fast == slow) {

          //Slow and faat pointers meet somewhere inside the cycle
          size = findLen(slow);

          //Find the head node
          cycleHead = findHead(size, head);
          break;

        }

      }
      
      return cycleHead;

    }

    private int findLen(ListNode node) {

        ListNode temp = node.next;
        int size = 1;

        while (temp != node) {
          temp = temp.next;
          size++;
        }

        return size;

      }

    private ListNode findHead(int len, ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head;

        //Move p2 ahead size times
        for (int i = 0; i < len; i++) {
          p2 = p2.next;
        }

        //Now they meet at the head
        while (p1 != p2) {

          p1 = p1.next;
          p2 = p2.next;

        }

        return p1;
        
      }

}