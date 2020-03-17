package Q3_01_Three_in_One;

import java.util.EmptyStackException;

public class GhoStack<T> {
  private static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }

    public T getValue() {
      return this.value;
    }
  }

  private Node<T> top;

  public void push(T value) {
    Node<T> t = new Node<T>(value);
    t.next = top;
    top = t;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public T peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return top.getValue();
  }

  public T pop() {
    if (isEmpty())
      throw new EmptyStackException();
    T value = top.getValue();
    top = top.next;
    return value;
  }
}
