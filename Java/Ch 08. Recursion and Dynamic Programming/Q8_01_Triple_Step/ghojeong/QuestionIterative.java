package Q8_01_Triple_Step.ghojeong;

import java.util.Arrays;

// spatial BigO = O(n)
// temporal BigO = O(n)

public class QuestionIterative {
  private static int[] map;

  public static int countWays(int n) {
    map = new int[n + 1];
    Arrays.fill(map, -1);
    return countWays(n, map);
  }

  private static int countWays(int n, int[] memo) {
    if (n < 0) {
      return 0;
    } else if (n < 2) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    memo[0] = 1;
    memo[1] = 1;
    memo[2] = 2;
    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
    }
    return memo[n];
  }
}
