package etc.heap;

public class Main {
  private static void print(int[] arr, Heap heap) {
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (val == 0) {
        System.out.println(heap.pop());
        continue;
      }
      heap.push(val);
    }
  }

  public static void main(String[] args) {
    System.out.println("\n# MaxHeap");
    int[] maxArr = { 0, 1, 2, 0, 0, 3, 2, 1, 0, 0, 0, 0, 0 };
    print(maxArr, new MaxHeap(maxArr.length));

    System.out.println("\n# MinHeap");
    int[] minArr = { 0, 12345678, 1, 2, 0, 0, 0, 0, 32 };
    print(minArr, new MaxHeap(minArr.length));
  }
}
