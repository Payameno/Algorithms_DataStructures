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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      ListNode dummy = new ListNode(), pre = dummy;

      //First digit carryOver
      int carryOver = 0;

      while (l1 != null || l2 != null) {

        //Get nodes value
        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;


        //Calculate the sum
        int sum = v1 + v2 + carryOver;
        carryOver = 0;

        //Bigger than 9, remove first digit - add to carryOver
        if (sum > 9) {
          sum = sum % 10;
          carryOver++;
        }

        //Create current Node 
        ListNode cur = new ListNode(sum % 10);

        //Create the Sum LinkedList
        pre.next = cur;

        //Dummy ->  cur
        //(1)pre  (2)pre
        pre = cur;

        //Move to next node
        l1 = l1 != null? l1.next : null;
        l2 = l2 != null? l2.next : null;

      }

      if (carryOver>0) {
        ListNode node = new ListNode(1);
        pre.next = node;
      }

      return dummy.next;

    }

}

/*
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */