package TwoPointers;

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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head, pre = dummy;

        while (cur != null) {

            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                } 
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            
            cur = cur.next;

        }
        return dummy.next;
    }

}

/*
Time complexity:
O(n) where n is the number of nodes

Space complexity:
O(1)



Input: head = [1,1,1,2,3]
            p      c n
Output: [2,3]

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */