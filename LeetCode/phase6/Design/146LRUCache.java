import java.util.*;

class LRUCache {

      class doublyLinkedNode {
        int value;
        int key;
        doublyLinkedNode next;
        doublyLinkedNode prev;
      }

      //Adding new node right after head
      private void addNode(doublyLinkedNode node) {

      node.prev = head;
      node.next = head.next;

      head.next.prev = node;
      head.next = node;

      }

      private void moveToHead(doublyLinkedNode node) {

        remove(node);
        addNode(node);

      }

      private doublyLinkedNode removeTailNode() {
      doublyLinkedNode node = tail.prev;
      cache.remove(node.value);
      remove(node);
      return node;
      }

      private void remove (doublyLinkedNode node) {

      doublyLinkedNode pre = node.prev;
      doublyLinkedNode nex = node.next;

      pre.next = nex;
      nex.prev = pre;

      }

      private HashMap<Integer, doublyLinkedNode> cache = new HashMap<>();
      private int capacity, counter;
      private doublyLinkedNode head, tail;

      //Constructor
      public LRUCache(int capacity) {
      this.capacity = capacity;
      this.counter = 0;
      this.head = new doublyLinkedNode();
      this.tail = new doublyLinkedNode();

      head.next = tail;
      head.prev = null;
      tail.prev = head;
      tail.next = null;
    }
    
    public int get(int key) {

      if (!cache.containsKey(key)) return -1;

      doublyLinkedNode node = cache.get(key);

      //return value + move node to head 
      moveToHead(node);

      return node.value;
    }
    
    public void put(int key, int value) {

      doublyLinkedNode node = cache.get(key);

      if (node == null) {

        //Create a new  node and place it to the head
        doublyLinkedNode newNode = new doublyLinkedNode();
        newNode.value = value;
        newNode.key = key;

        addNode(newNode);
        cache.put(key, newNode);
        counter++;

        //Check the capacity
        if (counter > capacity) {
          doublyLinkedNode tailNode = removeTailNode();
          cache.remove(tailNode.value);
          counter--;
        } 

      } else {
        //Update the value of the existing node
        node.value = value;

        //Move the existing node to the head
        moveToHead(node);
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