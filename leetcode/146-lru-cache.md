# [146. LRU Cache](https://leetcode.com/problems/lru-cache/)

```java
class LRUCache {

  class Node {
    Node prev;
    Node next;
    int key;
    int value;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    void push(Node node) {
      node.next = this.next;
      this.next = node;
      node.prev = this;
    }

    void pop() {
      if (this.prev != null) {
        this.prev.next = this.next;
      }
      if (this.next != null) {
        this.next.prev = this.prev;
      }
    }

    // public String toString() {
    //   return "(" + this.key + ", " + this.value + ")";
    // }
  }

  Node queueHead;
  Node queueTail;
  Node[] map;
  int capacity;
  int size = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new Node[3000];
  }

  void use(Node node) {
    if (node == queueTail) {
      return;
    }
    if (queueHead == node && node.next != null) {
      queueHead = node.next;
    }
    node.pop();
    queueTail.push(node);
    queueTail = node;
  }

  public int get(int key) {
    // System.out.println("\n\nget: " + key);
    // printQueue();

    if (map[key] == null) {
      return -1;
    }
    Node node = map[key];
    use(node);
    return node.value;
  }

  public void put(int key, int value) {
    // System.out.println("\n\nput: " + key + ", " + value);
    // printQueue();

    Node node = map[key];
    if (node != null) {
      node.value = value;
      use(node);
      return;
    }
    node = new Node(key, value);
    map[key] = node;

    if (size == 0) {
      queueHead = node;
      queueTail = node;
      size = 1;
      return;
    }

    queueTail.push(node);
    queueTail = node;
    if (size < capacity) {
      size++;
      return;
    }

    map[queueHead.key] = null;
    Node queueHeadNext = queueHead.next;
    queueHead.pop();
    queueHead = queueHeadNext;
  }

  // public void printQueue() {
  //   System.out.println("head: " + queueHead);
  //   System.out.println("tail: " + queueTail);

  //   Node node = queueHead;
  //   int i = 0;
  //   while (node != null && i < 10) {
  //     System.out.print(node + ", ");
  //     node = node.next;
  //     i++;
  //   }
  // }

  // public static void main(String[] args) {
  //   LRUCache cache = new LRUCache(2);

  //   cache.put(2, 1);
  //   cache.put(3, 2);
  //   cache.get(3);
  //   cache.get(2);
  //   cache.put(4, 3);
  //   cache.get(2);
  //   cache.get(3);
  //   cache.get(4);
  // }
}
```
