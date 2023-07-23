
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode(int x) {
//           val = x;
//           next = null;
//       }
//   }

class Solution {

    public ListNode detectCycle(ListNode head) {

      //base
      if (head == null || head.next == null) return null;
        
      //define slow and fast (turtle and hare algor)
      ListNode slow = head, fast = head;

      //find if there is a cycle
      while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {

          //find the length of the cycle
          int size = findLen(slow);

          //return the head of the cycle
          return findHead(size, head);

        }
      
      }

      return null;

    }

      private int findLen(ListNode node) {

        ListNode temp = node.next;
        int size = 1;

        while (temp != node) {

          temp = temp.next;
          size++;

        }
        return size;
      }

      private ListNode findHead(int len, ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < len; i++) {
          p2 = p2.next;
        }

        while (p1 != p2) {
          p1 = p1.next;
          p2 = p2.next;
        }

        return p1;
      }

    }