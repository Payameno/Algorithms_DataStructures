package FastSlow;

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
    public void reorderList(ListNode head) {

        //Base case
        if (head == null || head.next == null) return;

        //Define pointers:
        ListNode slow = head, fast = head, pre = null;

        //Using slow and fast pointers, slow will be positioned in the middle of the List
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Seperate the first half from the second half
        pre.next = null;

        //Reverse the second half
        slow = reverse(slow);

        //Combine the two halves
        ListNode p1 = head, p2 = slow;

        while (p1 != null && p2 != null) {
            ListNode nex1 = p1.next, nex2 = p2.next;

            p1.next = p2;
            /*
             * If the number of nodes in the list is odd, second half would have an extra node
             * therefore if there is no node after p1, we check if p2 still has any element
             */
            p2.next = nex1 == null? nex2: nex1;
            
            p1 = nex1;
            p2 = nex2;

        }

    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        //4 – 5 – 6 – null 
//                pre cur

        ListNode cur = head, pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre; 

            pre = cur;
            cur = temp;
        }
        
        return pre;
    }
}

/*
Using Fast and SLow pointers:

Null - 1 – 2 – 3 – 4 – 5 – 6 - null
                   S
               P
                                F

Now slow pointer is approx. at the middle (s = 4)

Now: p.next = null

1 – 2 – 3 – null

6 – 5 – 4 – null  -> Now reverse the second half

1 - 4 - 2 - 3 - 6 
p1 = null
p2 = null
next1 = null 
next2 = null

1 - 6 - 2 - 5 - 3 - 4 - 

reverse method:  6 – 5 – 4 – null    Second half reversed

desired linked list:  1 – 6 – 2 - 5 – 3 – 4 

p1 = 1 – 2 – 3 – null
p2 =  6 – 5 – 4 – null

-------------------------

Example:
 Input: head = [1,2,3,4,5]
 Output: [1,5,2,4,3]

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

 */