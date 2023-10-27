/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        //Base case
        if (headA == null || headB == null) return null;
        
        while (a != b) {
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        
        //return either a or b as they meet at intersection
        return a;

    }
    
}

/*
 * Time complexity:
 * O(m+n) where m is the number of nodes in headA and n nodes in headB
 * 
 * Space complexity:
 * O(1)
 * 
 * Solution:
 * Imagine two people walking two different paths, when they reach the
 * end of their corresponding path, they switch places at the other person's 
 * path. if there is an intersection there, they'll meeet at the same point
 */