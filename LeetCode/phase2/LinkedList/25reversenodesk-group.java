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

    public ListNode reverseKGroup(ListNode head, int k) {
        
        //Base case
        if (head.next == null) return head;
        if (k == 1) return head;

        //Define the dummy ListNode
        ListNode dummy = new ListNode();
        dummy.next = head;
        //Define pre and cur
        ListNode pre = dummy, cur = head;

            while (cur != null) {
                boolean space = thereIsSpace(cur, k);
                if (space) {
                    pre = reverse(pre, cur, k);
                    cur = pre.next;
            } else {
                break;
            }
        }

        //Return the head
        return dummy.next;
    }

    private boolean thereIsSpace(ListNode cur, int k) {
        
        for (int i = 1; i <= k; i++) {
            if (cur.next == null) return false;
            cur = cur.next;
        }

        return true;   

    }

    private ListNode reverse(ListNode pre, ListNode cur, int k) {
        // null -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // pre     cur  nex

        for (int i = 0; i < k - 1; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return cur;
    }
    
}

/*
 * Time Complexity:
 * 0(N) where n is the number nodes
 * 
 * Space Complexity:
 * O(1) constant memory
 * 
 * The problem needs K number of nodes to be reversed at a time
 * If K is larger than linkedlist, no reversal is performed
 * If number of nodes cannot be devided by K then only the portion where it is 
 * devisible will be reversed 
 */