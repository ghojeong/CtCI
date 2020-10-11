package sort;

public class Quick {

  public static void swap(int array[], int idx1, int idx2) {
    int value = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = value;
  }

  public static int partition(int array[], int lowIdx, int highIdx) {
    int pivotValue = array[highIdx];
    int pivotIdx = lowIdx;
    for (int i = lowIdx; i < highIdx; i++) {
      if (array[i] < pivotValue) {
        swap(array, pivotIdx++, i);
      }
    }
    swap(array, pivotIdx, highIdx);
    return pivotIdx;
  }

  public static void sort(int array[], int lowIdx, int highIdx) {
    if (lowIdx >= highIdx) {
      return;
    }
    int pivotIdx = partition(array, lowIdx, highIdx);
    sort(array, lowIdx, pivotIdx - 1);
    sort(array, pivotIdx + 1, highIdx);
  }

  public static int[] sorted(int[] array) {
    int[] arr = array.clone();
    sort(arr, 0, arr.length - 1);
    return arr;
  }
}
