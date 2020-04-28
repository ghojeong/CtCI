package etc.heap;

public abstract class Heap {
  // NOTE: arr[1] == root
  protected int[] arr;
  protected int size;

  public Heap(int capacity) {
    this.arr = new int[capacity];
    this.size = 0;
  };

  protected void swap(int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public abstract void push(int val);

  public abstract int pop();
}
