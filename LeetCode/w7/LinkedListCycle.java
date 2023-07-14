import javax.imageio.plugins.tiff.FaxTIFFTagSet;

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
 * 
 * Input: head = [3,2,0,-4], pos = 1
 *                       ^
 *                       ^
   Output: true
 */
class Solution {
    public boolean hasCycle(ListNode head) {

      //base case
      if (head == null || head.next == null) return false;

      //define fast and slow
      ListNode fast = head, slow = head;

      //check if there is a cycle
      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) return true;
      }

      //return false if there is no cycle
      return false;

    }
}