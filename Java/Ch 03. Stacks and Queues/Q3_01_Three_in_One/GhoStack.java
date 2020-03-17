package Q3_01_Three_in_One;

import java.util.EmptyStackException;

public class GhoStack<T> {
  private static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }

    public T getData() {
      return this.data;
    }
  }

  private Node<T> top;

  public void push(T data) {
    Node<T> t = new Node<T>(data);
    t.next = top;
    top = t;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public T peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return top.getData();
  }

  public T pop() {
    if (isEmpty())
      throw new EmptyStackException();
    T data = top.getData();
    top = top.next;
    return data;
  }
}
