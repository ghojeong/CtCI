import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainSol {

  public static class MinHeap {
    int[] arr;
    int size;

    // NOTE: arr[i]의 children 은 arr[i*2], arr[i*2 + 1]
    // Node -> Child Node , Node
    // children 끼리도 대소관계, parent -> children
    // 만약 root는 arr[1] 부터 시작하는 걸로 하고, arr[0]는 사용하지 않을 것

    public MinHeap(int capacity) {
      this.arr = new int[capacity + 1];
      this.size = 0;
    }

    public void swap(int i, int j) {
      int temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }

    // Big - O = lg n
    public void push(int val) {
      arr[++size] = val;
      // TODO: 모든 부모의 값이 자식보다 작거나 같도록 재정렬한다.
      // 맨 마지막 leaf node가 새롭게 추가된거고
      // arr[size]의 부모를 따라 올라가면서, 만약 부모가 큰 경우가 발생하면 swap을 하도록 한다.
      for (int idx = size; idx > 1; idx /= 2) {
        int pIdx = idx / 2;
        if (arr[idx] >= arr[pIdx]) {
          break;
        }
        swap(idx, pIdx);
      }
    }

    // Big-O = 1 -> min값을 get하기만 할 때
    // Big-O = lg n
    public int pop() {
      int root = arr[1];
      arr[1] = arr[size--];

      // TODO: 모든 부모의 값이 자식보다 작거나 같도록 재정렬한다.
      // root 에서 부터 마지막 leaf node, arr[size] 까지 루프 돌면서, 만약 부모가 큰 경우가 발생하면 swap을 하도록
      // 한다.

      int idx = 1;
      int cIdx = idx * 2;
      while (cIdx <= size) {
        if (cIdx + 1 <= size && arr[cIdx] > arr[cIdx + 1]) {
          cIdx++;
        }
        if (arr[cIdx] >= arr[idx]) {
          break;
        }
        swap(idx, cIdx);
        idx = cIdx;
        cIdx = idx * 2;
      }
      return root;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    MinHeap heap = new MinHeap(n);

    for (int i = 0; i < n; i++) {
      int val = Integer.parseInt(br.readLine());
      if (val == 0) {
        // TODO: Heap 에서 최소값을 pop해서 출력한다.
        if (heap.size < 1) {
          System.out.println(0);
          continue;
        }
        System.out.println(heap.pop());
        continue;
      }
      // TODO: val을 Heap 자료구조에 push 한다.
      heap.push(val);
    }
  }
}
