package sort;

import java.util.Arrays;

public class Bubble {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 버블 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
