package Q3_01_Three_in_One;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class GhoStack<T> {
  private static class Node<T> {
    // TODO:
    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }

  private Node<T> top;

  public void push(T value) {
    // TODO:
    Node<T> node = new Node<T>(value);
    node.next = top;
    top = node;
  }

  public boolean isEmpty() {
    // TODO:
    return top == null;
  }

  public T peek() {
    // TODO:
    if (isEmpty())
      throw new EmptyStackException();
    return top.value;
  }

  public T pop() {
    // TODO:
    if (isEmpty())
      throw new EmptyStackException();
    T value = top.value;
    top = top.next;
    return value;
  }

  public ArrayList<T> toArrayList() {
    ArrayList<T> arrayList = new ArrayList<T>();
    Node<T> itr = top;
    while (itr != null) {
      arrayList.add(itr.value);
      itr = itr.next;
    }
    return arrayList;
  }
}
