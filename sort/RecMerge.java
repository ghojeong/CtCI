package sort;

import java.util.Arrays;

// [Recursive Merge Sort](https://www.geeksforgeeks.org/iterative-merge-sort/)
public class RecMerge {

  private static void merge(int[] arr, int[] left, int[] right) {
    int i = 0;
    int j = 0;
    int k = 0;

    // Merge left and right arrays
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    // Collect remaining elements
    while (i < left.length) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while (j < right.length) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }

  private static void sort(int[] arr) {
    if (arr == null) {
      return;
    }

    if (arr.length > 1) {
      int mid = arr.length / 2;

      // Split left part
      int[] left = new int[mid];
      for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
      }

      // Split right part
      int[] right = new int[arr.length - mid];
      for (int i = mid; i < arr.length; i++) {
        right[i - mid] = arr[i];
      }
      sort(left);
      sort(right);
      merge(arr, left, right);
    }
  }

  public static int[] sorted(int[] array) {
    int[] arr = Arrays.copyOf(array, array.length);
    sort(arr);
    return arr;
  }
}
