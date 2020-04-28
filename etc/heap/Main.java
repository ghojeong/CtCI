package etc.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // Heap heap = new MinHeap(n);
    Heap heap = new MaxHeap(n);

    for (int i = 0; i < n; i++) {
      int val = Integer.parseInt(br.readLine());
      if (val == 0) {
        System.out.println(heap.pop());
        continue;
      }
      heap.push(val);
    }
  }
}
