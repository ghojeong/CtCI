package Q3_01_Three_in_One;

import java.util.EmptyStackException;

public class GhoStack<T> {
  private static class Node<T> {
    private T val;
    private Node<T> next;

    public Node(T val) {
      this.val = val;
    }

    public T getVal() {
      return this.val;
    }
  }

  private Node<T> top;

  public void push(T val) {
    Node<T> t = new Node<T>(val);
    t.next = top;
    top = t;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public T peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return top.getVal();
  }

  public T pop() {
    if (isEmpty())
      throw new EmptyStackException();
    T val = top.getVal();
    top = top.next;
    return val;
  }
}
