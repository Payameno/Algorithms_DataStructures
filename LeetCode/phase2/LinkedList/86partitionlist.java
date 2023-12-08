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
    public ListNode partition(ListNode head, int x) {

        //Base case
        if (head == null || head.next == null) return head;

        //Two seperate lists two hold values smaller and greater than x
        ListNode dummyMin = new ListNode(), dummyMax = new ListNode();
        ListNode Min = dummyMin, Max = dummyMax;

        //Create a pointer
        ListNode cur = head;

        while (cur != null) {

            if (cur.val < x) {
                Min.next = cur;
                Min = Min.next;

            } else {
                Max.next = cur;
                Max = Max.next;
            }

            cur = cur.next;
        }

        //Merge two lists
        Min.next = dummyMax.next;
        Max.next = null;
        
        return dummyMin.next;
    }
}

/*

Time complexity:
O(N) where N is the number of Nodes in the singly linkedList

Space complexity:
O(1) in the dummyMin and dummyMax, we are just referencing to the linkedlist
object, not creating new nodes. therefore the space complexity remains constant

Solution:
We create two seperate lists, one that holds the values lesx than x
the other holds the values greater than x
finally we merge them


dummyMin dummyMax Min Max:

>Maintain the Head of the Lists: dummyMin and dummyMax always point to the head of
 the respective lists, which is necessary for merging the lists at the end and 
 returning the result.
>Ease of Insertion: Min and Max can move along the lists as new nodes are added, 
making it easy to insert nodes at the end of each list without losing track of 
the list heads.


 Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */