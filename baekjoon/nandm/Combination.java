package baekjoon.nandm;

import java.util.*;
import java.io.*;

public class Combination {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int[] bucket = new int[r];

    pick(bucket, n, r);
  }

  public static void pick(int[] bucket, int n, int k) {
    int lastIndex, smallest;

    if (k == 0) {
      for (int i = 0; i < bucket.length; i++) {
        System.out.print(bucket[i] + " ");
      }
      System.out.println();
      return;
    }

    lastIndex = bucket.length - k - 1;

    if (bucket.length == k) {
      smallest = 1;
    } else {
      smallest = bucket[lastIndex] + 1;
    }

    for (int item = smallest; item <= n; item++) {
      bucket[lastIndex + 1] = item;
      pick(bucket, n, k - 1);
    }
  }
}
