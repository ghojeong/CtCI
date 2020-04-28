package etc.heap;

public class MinHeap extends Heap {
  public MinHeap(int capacity) {
    super(capacity);
  };

  public void push(int val) {
    arr[++size] = val;

    // NOTE: arr[i/2] == parent of arr[i]
    for (int idx = size; idx > 1; idx /= 2) {
      int pIdx = idx / 2;
      if (arr[pIdx] <= arr[idx]) {
        break;
      }
      swap(idx, pIdx);
    }
  }

  public int pop() {
    if (size < 1) {
      return 0;
    }
    int root = arr[1];
    arr[1] = arr[size--];

    // NOTE: arr[i*2], arr[i*2 + 1] : children of arr[i]
    for (int idx = 1; idx * 2 <= size;) {
      int cIdx = idx * 2;
      if (cIdx < size && arr[cIdx] > arr[cIdx + 1]) {
        cIdx++;
      }
      if (arr[idx] <= arr[cIdx]) {
        break;
      }
      swap(idx, cIdx);
      idx = cIdx;
    }
    return root;
  }
}
