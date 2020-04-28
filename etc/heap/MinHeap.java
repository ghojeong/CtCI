package etc.heap;

public class MinHeap extends Heap {
  public MinHeap(int capacity) {
    super(capacity);
  };

  protected int priority(Object item) {
    return -Integer.parseInt(item.toString());
  }
}
