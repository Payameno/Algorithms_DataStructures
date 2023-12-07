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

    public ListNode swapPairsIterative(ListNode head) {

        //Base
        if (head == null || head.next == null) return head;

        /*
         Solution using iterative approach:
         */

        //Define pointers
        ListNode pre = null, cur = null;

        //Define the dummy list
        ListNode dummy = new ListNode();
        dummy.next = head;
        pre = dummy;
        cur = head;

        //Iterate to swap
        while (cur != null && cur.next != null) {

            //swap
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = cur;
            pre.next = nex;

            //Move pointers forward
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        /*
         Recursive solution
         */

         //Base case
         if (head == null || head.next == null) return head;

         ListNode nex = head.next;
         ListNode temp = nex.next;
         //Recursively will swap the rest of the list
         head.next = swapPairs(temp);
         nex.next = head;

         return nex;
    }

}

/*
 <Time complexity>
 Solution 1 (Iterative):
 O(N)
Where N is the number of nodes in the list

 Solution 2 (Recursive):
 O(N)

 <Space complexity>
 Solution 1 (Iterative):
O(1)
 Solution 2 (Recursive):
 O(N)
 N is the depth of the recursion call stack


Example 1:
Input: head = [1,2,3,4]
             p c n

     pre -> 2 -> 1 -> 4 -> 3 -> null
                 p    c    n

Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */