package Q8_05_Recursive_Multiply.ghojeong;

public class QuestionG extends Question {
  public QuestionG(String label) {
    super.label = label;
  }

  public static int memo[];

  public int prodHelper(int small, int big) {
    if (small < 1) {
      return 0;
    }
    if (small == 1) {
      return big;
    }
    if (memo[small] > 0) {
      return memo[small];
    }
    counter += 1;
    if ((small & 1) == 0) {
      counter += 1;
      memo[small] = prodHelper(small >> 1, big << 1);
      return memo[small];
    }
    counter += 2;
    int s = small >> 1;
    int prodS = prodHelper(s, big);
    memo[s] = (prodS << 1) + big;
    return memo[s];
  }

  public int minProduct(int a, int b) {
    int small = a < b ? a : b;
    int big = a > b ? a : b;
    memo = new int[small + 1];
    return prodHelper(small, big);
  }
}
