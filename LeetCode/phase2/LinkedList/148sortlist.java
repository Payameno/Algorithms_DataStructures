package LinkedList;

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

    public ListNode sortList(ListNode head) {
        
        //Base Case
        if (head == null || head.next == null) return head;

        ListNode l1 = head, l2 = splitMidNode(head);

        //Sort each half recursively
        l1 = sortList(l1);
        l2 = sortList(l2);

        //Define the res list
        ListNode dummy = new ListNode(), res = dummy; 

        //Sort the lists
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }

            res = res.next;
        }

        //In the case two list are not the same size
        if (l1 != null) {
            res.next = l1;
        } else if (l2 != null) {
            res.next = l2;
        }

        //Return the merge and sorted list
        return dummy.next;

    }

    private ListNode splitMidNode(ListNode head) {
        //Fast & slow technique
        ListNode slow = head, fast = head, pre = null;

        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //cut the connection before slow
        pre.next = null;

        //By the time fast reaches the end slow is aprox. in the middle
        return slow;
    }

}

/*
 Time complexity:
    >Recursive call: Since the list is halved at each level, the time complexity to recursively
    call sort method would be O(logn) where n is the number of nodes in the linkedlist
    >Merging two lists: The list is merged at each level of recursion, resulting in an overal
    time complexity of O(n) where n is the number of nodes in the linkedlist

    Overal time complexity for the algorithm would be O(n Log n)

 Space complexity:

    >Call stack space: since we recursively call sortlist method, it takes O(logn) extra space
    for the call stack (Since the list is halved at each level)
    >In this algorithm merging the nodes will not take any extra space as in the linkedlist only
    connections will be changed and no extra node is created

    Overal: O(logn)


Input: head = [-1,5,3,4,0]
cut into two halves
[-1,5] -> 
[3,4,0] -> []



Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 */