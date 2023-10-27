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

class solution {

    public ListNode middleNOde(ListNode head) {

        //Base case
        if (head.next == null) return head;

        //Define fast & slow pointer
        ListNode fast = head, slow = head;

        //Perform the move
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
         
        //Slow is positioned in the middle at the end
        return slow;
    }
    
}

/*
 * Time Complexity:
 * O(N) Linear
 * 
 * Space Complexity:
 * O(1)
 * 
 *  Description:
 *  Number of integers, odd or even will be the same with the following approach
 *  Fast pointer moves 2 nodes ahead, by the time it reaches the end the
 *  slower pointer is in the middle.
 * 
 * Example:
 * Input = {1,2,3,4,5}
 *              S
 *                  F
 * Output = 3 (ListNode Object)
 * 
 */
