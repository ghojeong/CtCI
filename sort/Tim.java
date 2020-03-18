package sort;

import java.util.Arrays;

public class Tim {
  public static <T> T[] sort(T[] array) {
    T[] arr = array.clone();
    // TODO: 팀 정렬 구현
    Arrays.sort(arr);
    return arr;
  }
}
