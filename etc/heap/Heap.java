package etc.heap;

public abstract class Heap {
  // NOTE: arr[1] == root
  private Object[] arr;
  private int size;

  public Heap(int capacity) {
    this.arr = new Object[capacity];
    this.size = 0;
  };

  private void swap(int i, int j) {
    Object tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // NOTE: priority 값이 더 높은게, 우선적으로 pop 되어야 한다.
  protected abstract int priority(Object item);

  // Big-O == O(lg n)
  public void push(int val) {
    arr[++size] = val;

    // NOTE: arr[i/2] == parent of arr[i]
    for (int idx = size; idx > 1; idx /= 2) {
      int pIdx = idx / 2;
      if (priority(arr[pIdx]) >= priority(arr[idx])) {
        break;
      }
      swap(idx, pIdx);
    }
  }

  // Big-O == O(lg n)
  public Object pop() {
    if (size < 1) {
      return 0;
    }
    Object root = arr[1];
    arr[1] = arr[size--];

    // NOTE: arr[i*2], arr[i*2 + 1] : children of arr[i]
    for (int idx = 1; idx * 2 <= size;) {
      int cIdx = idx * 2;
      if (cIdx < size && priority(arr[cIdx]) < priority(arr[cIdx + 1])) {
        cIdx++;
      }
      if (priority(arr[idx]) >= priority(arr[cIdx])) {
        break;
      }
      swap(idx, cIdx);
      idx = cIdx;
    }
    return root;
  }
}
