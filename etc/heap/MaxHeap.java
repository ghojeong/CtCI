package etc.heap;

public class MaxHeap extends Heap {
  public MaxHeap(int capacity) {
    super(capacity);
  }

  protected int priority(Object item) {
    return Integer.parseInt(item.toString());
  }
}
