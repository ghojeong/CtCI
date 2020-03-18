package sort;

import java.util.Arrays;

public class Insertion {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 삽입 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
