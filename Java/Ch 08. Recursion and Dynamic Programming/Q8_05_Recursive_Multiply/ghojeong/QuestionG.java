package Q8_05_Recursive_Multiply.ghojeong;

public class QuestionG {

  public static int prodRec(int small, int big, int acc) {
    if (small < 1) {
      return acc;
    }
    return prodRec(small - 1, big, acc + big);
  }

  public static int product(int a, int b) {
    // return a * b;

    // int prod = 0;
    // for (int i = 0; i < b; i++) {
    // prod += a;
    // }
    // return prod;

    if (a <= b) {
      return prodRec(a, b, 0);
    }
    return prodRec(b, a, 0);
  }

  public static void main(String[] args) {
    int a = 13494;
    int b = 22323;
    System.out.println(a * b);
    System.out.println(product(a, b));
  }
}
