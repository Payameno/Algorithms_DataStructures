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
    public ListNode removeElements(ListNode head, int val) {

        //Base
        if (head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        while (cur != null) {

            //Remove node if the value matches
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
              //Move cur,pre both forward if value does not need to be eliminated
                pre = pre.next;
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}