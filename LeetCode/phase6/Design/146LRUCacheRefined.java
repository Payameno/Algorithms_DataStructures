class LRUCacheR {

    class dLinkedNode {
      int key;
      int value;
      dLinkedNode pre;
      dLinkedNode post;
    }

    /*
     * Alaways add the node after head
     */

    private void addNode (dLinkedNode node) {

      node.pre = head;
      node.post = head.post;

      head.post.pre = node;
      head.post = node;

    }

    /*
     * Remove an exisitng node from the linked list
     */

    private void removeNode (dLinkedNode node) {

      dLinkedNode pre = node.pre;
      dLinkedNode post = node.post;

      pre.post = post;
      post.pre = pre;

    }

    /*
     * Move a certain node next to the head
     */

     private void moveToHead (dLinkedNode node) {

      this.removeNode(node);
      this.addNode(node);

     }

     /*
      * Pop the current tail
      */

    private dLinkedNode popTail() {

      dLinkedNode node = tail.pre;
      this.removeNode(node);
      return node;

    }

    private HashMap<Integer, dLinkedNode> cache = new HashMap<Integer, dLinkedNode>();
    private int capacity;
    private int count;
    private dLinkedNode head, tail;

  public LRUCache(int capacity) {
  
    this.capacity = capacity;
    this.count = 0;

    head = new dLinkedNode();
    head.pre = null;

    tail = new dLinkedNode();
    tail.post = null;

    head.post = tail;
    tail.pre = head;

  }

  public int get(int key) {

    dLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }

    this.moveToHead(node);
    return node.value;
      
  }

  public void put(int key, int value) {

    dLinkedNode node = cache.get(key);

    if (node == null) {

      dLinkedNode newNode = new dLinkedNode();
      newNode.key = key;
      newNode.value = value;

      this.cache.put(key, newNode);
      this.addNode(newNode);
      count++;

      if(count > capacity) {
        
        dLinkedNode tailNode = this.popTail();
        this.cache.remove(tailNode.key);
        count--;

      }

    } else {

      node.value = value;
      this.moveToHead(node);

    }

  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */