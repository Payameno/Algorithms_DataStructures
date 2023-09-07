package FastSlow;
import java.util.LinkedList;

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

    public boolean hasCycle(ListNode head) {

     //base
      if (head == null || head.next == null) return false;

      //Define fast and slow pointers
      ListNode slow = head, fast = head;

      //Traverse the list, evaluate a cycle
      while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (fast == slow) return true;

      }

      //Cycle not found
      return false;
        
    }

}

/*

(tortoise and hare algorithm)
  
 * Input: head = [3,2,0,-4], pos = 1
  Output: true

  Input: head = [1], pos = -1
  Output: false

  With Floyd's cycle-finding algorithm slow and fast pointers will meet somewhere 
  in cycle

  Time complexity = O(n)
  Space complexity (memory) = O(1)
 */