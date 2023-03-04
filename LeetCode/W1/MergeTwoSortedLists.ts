//linkedList definition
/**
 * class listNode {
 *  value: number;
 *  next: listNode || null;
 *  constructor (_value: number || null, _next: listNode || null) {
 *    this.value = (_value === undefined? 0 : -value);
 *    this.next = (_next === undefined? null : _next);
 *  }
 * }
 */

function mergeTwoLists(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  if (l1 === null) return l2;
  if (l2 === null) return l1;

  if (l1.val < l2.val) 
         {l1.next = mergeTwoLists(l1.next, l2); return l1}
    else {l2.next = mergeTwoLists(l2.next, l1); return l2}
}