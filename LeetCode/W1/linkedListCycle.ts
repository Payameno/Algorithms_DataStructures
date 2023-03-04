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

function hasCycle(head: ListNode | null): boolean {
    const nodeSet = new Set<ListNode | null>()
    let result: boolean = false

    while (head && !result) {
      {nodeSet.has(head)
        ? 
        result = true 
        : 
        nodeSet.add(head)
        head = head.next}
    }
    return result;
};