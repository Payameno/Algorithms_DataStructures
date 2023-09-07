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
class Solution3 {
    public ListNode oddEvenList(ListNode head) {

        //Base
        if (head == null || head.next == null) return head;

        //Define odd & even lists for reference
        ListNode oddList = head, evenList = head.next;

        //Define odd and even pointers for manipulation
        ListNode curOdd = oddList, curEven = evenList;

        //Go throught the list and build lists by reference
        while (curOdd.next != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;

            curEven.next = curOdd.next;
            curEven = curEven.next;
        }

        //Tail node of oddList points to the evenList
        curOdd.next = evenList;

        //return the OddList which contains both even and odd values
        return oddList;
        
    }
}