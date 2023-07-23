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

    public boolean hasCycle(ListNode head) {

      //base
      if (head == null || head.next == null) {
        return false;
      }

      //define pointers
      ListNode slow = head, fast = head;

      //solution
      while (fast != null && fast.next != null) {
        
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
          return true;
        }

      }
    
      return false;
    }


}

//Input: head = [3,2,0,-4]