public class Fibonacci {

  // Temporal Complexity: O(2^n)
  // Spatial Complexity: O(2^n)
  public static int fibRec(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibRec(n - 1) + fibRec(n - 2);
  }

  // Temporal Complexity: O(n)
  // Spatial Complexity: O(n)
  public static int fibDynamic(int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    int f[] = new int[n + 1];
    int i;

    f[0] = 0;
    f[1] = 1;
    for (i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  // Temporal Complexity: O(n)
  // Spatial Complexity: O(1)
  public static int fibDynamicOptimized(int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    int f_2 = 0, f_1 = 1, f = 1;
    for (int i = 2; i <= n; i++) {
      f = f_1 + f_2;
      f_2 = f_1;
      f_1 = f;
    }
    return f;
  }

  public static void main(String a[]) {
    int n = 25;

    System.out.println("\n Recursion");
    for (int i = 0; i < n; i++) {
      System.out.print(fibRec(i) + " ");
    }

    System.out.println("\n\n Dynamic Programming");
    for (int i = 0; i < n; i++) {
      System.out.print(fibRec(i) + " ");
    }

    System.out.println("\n\n Optimized Dynamic Programming");
    for (int i = 0; i < n; i++) {
      System.out.print(fibRec(i) + " ");
    }
  }
}
