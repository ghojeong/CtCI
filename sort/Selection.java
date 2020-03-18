package sort;

import java.util.Arrays;

public class Selection {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 선택 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
