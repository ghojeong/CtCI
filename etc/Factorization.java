import java.util.LinkedList;

public class Factorization {

  // 인수분해하는 함수
  // O(n lg n)
  public static LinkedList<Integer> factorize(int num) {
    if (num < 2) {
      return null;
    }
    LinkedList<Integer> ll = new LinkedList<Integer>();
    for (int i = 2, n = num; i <= num && n > 1; i++) {
      while (n % i == 0 && n > 1) {
        ll.add(i);
        n /= i;
      }
    }
    return ll;
  }

  public static void main(String a[]) {
    System.out.println(factorize(12));
    System.out.println(factorize(1024));
    System.out.println(factorize(30030));
  }
}
