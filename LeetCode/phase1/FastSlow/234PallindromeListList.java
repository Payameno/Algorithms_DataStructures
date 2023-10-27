/*
 * Definition for signly-Linked-List:
 * 
 * public class ListNode {
 *  int val;
 *  ListNode next;
 *  ListNode() {}
 *  ListNode(int val) {this.val = val;}
 *  ListNode(int val, ListNoded next) {
 *  this.val = val;
 *  this.next = next;
 * }
 * 
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {

        //Base
        if (head == null || head.next == null) return true;

        //Define Slow & Fast pointers
        ListNode fast = head, slow = head;

        //Move pointers so that slow reaches the middle
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half, compare with the first half
        ListNode L = head, R = reverse(slow);

        //Compare
        while (R != null) {
            if (R.val == L.val) {
                R = R.next;
                L = L.next;
            } else {
                return false;
            }
        }
        return true;    }

    private ListNode ListNode(ListNode head) {
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
Time Complexity:
O(N)

Space Complexity:
O(1)


 * Problem: 
 * Given a singly LinkedList determine if it is a palindrome.
 * 
 * Solution Approach:
 * Reverse the second half of the LinkedList, compare with the first half
 * if they match this is a Palindrome LinkedList. 
 * Example
 * Input 1 -> 2
 * Output: false
 * 
 * Example2
 * Input 1 -> 2 -> 2 -> 1
 *                 S
 *                         F
 * 
 * 
 * Output: True
 */