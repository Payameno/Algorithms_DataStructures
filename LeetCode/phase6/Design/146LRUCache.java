import java.util.*;

class doublyLinkedNode {
  int value;
  int key;
  doublyLinkedNode next;
  doublyLinkedNode prev;
}

class LRUCache {

    private HashMap<Integer, doublyLinkedNode> map = new HashMap<>();
    private int capacity;
    private doublyLinkedNode head, tail;
    private int nodeCount;
    
    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.head = new doublyLinkedNode();
      this.tail = new doublyLinkedNode();
      this.nodeCount = 0;

      head.next = tail;
      tail.prev = head;
    }

    //Adding new node right after head
    private void addNodeToHead(doublyLinkedNode node) {
      doublyLinkedNode pre = head;
      doublyLinkedNode after = head.next;

      pre.next = node;
      node.prev = pre;

      after.prev = node;
      node.next = after;
    }

    private doublyLinkedNode removeTailNode() {
      doublyLinkedNode node = tail.prev;
      remove(node);
      return node;
    }

    private void remove (doublyLinkedNode node) {

      doublyLinkedNode pre = node.prev;
      pre.next = tail;
      tail.prev = pre;

      node.next = null;
      node.prev = null;
    }
    
    public int get(int key) {

      doublyLinkedNode node = map.get(key);
      if (node == null) return -1;

      //return value + move node to head 
      addNodeToHead(node);

      return node.value;
    }
    
    public void put(int key, int value) {

      doublyLinkedNode node = map.get(key);

      if (node == null) {
        doublyLinkedNode newNode = new doublyLinkedNode();
        newNode.value = value;
        newNode.key = key;

        map.put(key, newNode);
        addNodeToHead(newNode);
        nodeCount++;

        //Check the capacity
        if (nodeCount > capacity) {
        doublyLinkedNode tailNode = removeTailNode();
        map.remove(tailNode.key);
        nodeCount--;
      } 

      } else {
        node.value = value;
      }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * 
 *  EXample: capacity = 3;
 *  [[key1,value1],[key2,value2].....]
 *  dummyHead 4x 3x 1x 2x dummyTail 
 *  
 *  For get method, we would use a map to keep time complx O(1)
 * Without a doubly linkedlist, we have to traverse the list n times to get 
 * to the last item, hence the use of doublylist
 * 
 * Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 */