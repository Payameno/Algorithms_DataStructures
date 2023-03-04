/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function middleNode(head: ListNode | null): ListNode | null {

  let slow: ListNode | null = head;
  let fast: ListNode | null = head;
  let count = 0;

  while(fast) {
    if (count%2 === 1) {
      slow = slow!.next;
    }
    fast = fast.next;
    count++;
  }

  return slow;
};