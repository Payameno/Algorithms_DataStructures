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

    public ListNode reverseList(ListNode head) {

      //base
      if (head == null) return null;

      //Define pointers
      ListNode pre = null, cur = head;

      while (cur != null) {

        ListNode temp = cur.next;
        cur.next = pre;

        //Move pointers to the right
        pre = cur;
        cur = temp;
        
      }

      return pre;
        
    }

}

/*
 * Input: head = [1,2,3,4,5]
                         pre = 5    
                            cur = null
 */