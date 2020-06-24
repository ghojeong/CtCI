public class Fibonacci {

  // 1. Top-Down 혹은 Bottom-up 으로 일단 효율성에 상관없이 식을 만든다.
  // 2. 최적화 ( recursion을 iterative 함수로 바꾸기 + memoization (결과를 array에 저장하기) )
  // 3. 심화된 최적화 memoization 한 array size 줄이기

  Integer[] memo;
  int memoSize = 1024;

  public Fibonacci() {
    memo = new Integer[memoSize];
    memo[0] = 0;
    memo[1] = 1;
  }

  // a(n) = a(n-1) + a(n-2) => 2^n
  public int fibonacci(int n) {

    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (memo[n] != null) {
      return memo[n];
    }
    memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    // return memo[n]; // 딱 여기까지가 memoization

    // iteration
    for (int i = 2; i <= n; i++) {
      memo[i] = memo[n - 1] + memo[n - 2];
    }

    return memo[n];
  }

  public static void main(String[] args) {
    int max = 35; // WARNING: If you make this above 40ish, your computer may serious slow down.
    int trials = 10; // Run code multiple times to compute average time.
    double[] times = new double[max]; // Store times
    Fibonacci fib = new Fibonacci();
    for (int j = 0; j < trials; j++) { // Run this 10 times to compute
      for (int i = 0; i < max; i++) {
        long start = System.currentTimeMillis();
        System.out.println(i + ": " + fib.fibonacci(i));
        long end = System.currentTimeMillis();
        long time = end - start;
        times[i] += time;
      }
    }
    for (int j = 0; j < max; j++) {
      System.out.println(j + ": " + times[j] / trials + "ms");
    }
  }
}
