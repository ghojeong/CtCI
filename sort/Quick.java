package sort;

public class Quick {

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int pi = low; // partitioning index
    for (int i = low; i < high; i++) {
      if (arr[i] < pivot) {
        swap(arr, pi++, i);
      }
    }
    swap(arr, pi, high);
    return pi;
  }

  private static void sort(int arr[], int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high); // partitioning index
      sort(arr, low, pi - 1);
      sort(arr, pi + 1, high);
    }
  }

  public static int[] sorted(int[] array) {
    int[] arr = array.clone();
    sort(arr, 0, arr.length - 1);
    return arr;
  }
}
