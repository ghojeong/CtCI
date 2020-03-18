package sort;

import java.util.Arrays;

public class Quick {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 퀵 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
