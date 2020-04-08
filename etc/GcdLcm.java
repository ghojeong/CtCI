public class GcdLcm {
  // a, b: 정수; r == a mod b;
  // NOTE: gcd(a,b) == gcd(b,r)
  public static int gcdRec(int a, int b) {
    int r = a % b;
    if (r == 0) {
      return b;
    }
    return gcdRec(b, r);
  }

  public static int gcd(int num1, int num2) {
    int a, b, r;
    if (num1 > num2) {
      a = num1;
      b = num2;
    } else {
      a = num2;
      b = num1;
    }
    // return gcdRec(a, b);

    // for (;;) {
    // r = a % b;
    // if (r == 0) {
    // return b;
    // }
    // a = b;
    // b = r;
    // }

    while (a % b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return b;
  }

  public static int lcm(int num1, int num2) {
    return num1 * num2 / gcd(num1, num2);
  }

  public static void main(String a[]) {
    System.out.println(gcd(12, 8));
    System.out.println(lcm(12, 8));
    System.out.println(gcd(13, 15));
    System.out.println(lcm(13, 15));
  }
}
