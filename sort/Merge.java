package sort;

import java.util.Arrays;

public class Merge {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 병합 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
