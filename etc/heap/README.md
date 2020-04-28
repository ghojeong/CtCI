# Heap

- 최소, 최대 힙과 관련된 코드
- Priority Queue를 사용하고 싶을 때 Heap 을 직접 구현해야만 한다.

## Command

```sh
javac -Xlint -d ./Java/classes ./etc/heap/*.java

java -cp ./Java/classes etc.heap.Main
```

## 백준 링크

- [최소힙](https://www.acmicpc.net/problem/1927)
- [최대힙](https://www.acmicpc.net/problem/11279)
- [우선순위 큐 스텝](https://www.acmicpc.net/step/13)
- [우선순위 큐 문제](https://www.acmicpc.net/problem/tag/%EC%9A%B0%EC%84%A0%20%EC%88%9C%EC%9C%84%20%ED%81%90)

## 백준 풀이

### 최소힙

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static class MinHeap {
    // NOTE: arr[1] == root
    private int[] arr;
    private int size;

    public MinHeap(int capacity) {
      this.arr = new int[capacity];
      this.size = 0;
    };

    public int size() {
      return size;
    }

    private void swap(int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }

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

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    MinHeap heap = new MinHeap(n);

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
```

### 최대힙

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static class MaxHeap {
    // NOTE: arr[1] == root
    private int[] arr;
    private int size;

    public MaxHeap(int capacity) {
      this.arr = new int[capacity];
      this.size = 0;
    };

    public int size() {
      return size;
    }

    private void swap(int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }

    public void push(int val) {
      arr[++size] = val;

      // NOTE: arr[i/2] == parent of arr[i]
      for (int idx = size; idx > 1; idx /= 2) {
        int pIdx = idx / 2;
        if (arr[pIdx] >= arr[idx]) {
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
        if (cIdx < size && arr[cIdx] < arr[cIdx + 1]) {
          cIdx++;
        }
        if (arr[idx] >= arr[cIdx]) {
          break;
        }
        swap(idx, cIdx);
        idx = cIdx;
      }
      return root;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    MaxHeap heap = new MaxHeap(n);

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
```
