package sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    Random random = new Random();
    int length = 25;
    Integer array[] = new Integer[length];
    for (int i = 0; i < length; i++) {
      array[i] = 1 + random.nextInt(length);
    }
    Integer arr[] = array.clone();

    System.out.println();
    System.out.println("arr:   " + Arrays.toString(array));
    System.out.println();

    Arrays.sort(arr);
    System.out.println("sort:  " + Arrays.toString(arr)); // 정답
    System.out.println("Quick: " + Arrays.toString(Quick.<Integer>sort(array)));
    System.out.println("Tim:   " + Arrays.toString(Tim.<Integer>sort(array)));

    System.out.println();
    System.out.println("arr:   " + Arrays.toString(array));
  }
}
