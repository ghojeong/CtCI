package Q2_01_Remove_Dups;

import java.util.HashSet;

public class GhoLinkedList<T> {
  private class Node<T> {
    private T value;
    private Node<T> next;

    Node(T value) {
      this.value = value;
    };
  }

  public Node<T> head;
  public Node<T> tail;

  public void add(T value) {
    Node<T> node = new Node(value);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = tail.next;
    }
  }

  public String toString() {
    if (head == null) {
      return "";
    }
    Node<T> itr = head;
    String str = "\n[" + itr.value;
    itr = itr.next;
    while (itr != null) {
      str += " -> " + itr.value;
      itr = itr.next;
    }
    return str + "]";
  }

  public void deleteDups() {
    if (head == null) {
      return;
    }
    HashSet<T> set = new HashSet<T>();
    Node<T> itr = head;
    Node<T> itrPrev = itr;
    itr = itr.next;
    while (itr != null) {
      if (set.contains(itr.value)) {
        // remove current itr Node
        itrPrev.next = itr.next;
        itr = itrPrev.next;
      } else {
        set.add(itr.value);
        itrPrev = itr;
        itr = itr.next;
      }
    }
  }
}
