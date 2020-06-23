package Q8_01_Triple_Step.ghojeong;

// spatial BigO = O(1)
// temporal BigO = O(n)
public class QuestionOptimized {

  public static int countWays(int n) {
    if (n < 0) {
      return 0;
    } else if (n < 2) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    int a = 1;
    int b = 1;
    int c = 2;
    int ways = a + b + c;
    for (int i = 3; i <= n; i++) {
      ways = a + b + c;
      a = b;
      b = c;
      c = ways;
    }
    return ways;
  }

}
