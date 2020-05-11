package Q5_01_Insertion.ghojeong;

public class Question {

  private static String toFullBinaryString(int a) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      b = b.insert(0, a & 1);
      a = a >> 1;
    }
    return b.toString();
  }

  public static Integer updateBits(int n, int m, int i, int j) {
    if (i > j || i < 0 || j >= 32) {
      return null;
    }
    int allOnes = ~0; // allOnes = 11111111

    int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000
    int right = ((1 << i) - 1); // 1s after position i. right = 00000011
    int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011

    int n_cleared = n & mask; // Clear bits j through i.
    int m_shifted = m << i; // Move m into correct position.

    return n_cleared | m_shifted;
  }

  public static void main(String[] args) {
    int a = ~23423;
    System.out.println(toFullBinaryString(a));
    int b = 5;
    System.out.println(toFullBinaryString(b));
    int c = updateBits(a, b, 29, 31);
    System.out.println(toFullBinaryString(c));
  }
}
