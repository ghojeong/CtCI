package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;
import java.math.BigInteger;

public class TOH {
  private static BufferedReader br;
  private static BufferedWriter bw;

  private static class Tower {
    private int top = -1;
    private int stack[];
    private final char name;

    public Tower(int size, char name) {
      this.stack = new int[size];
      this.name = name;
    }

    Tower initializeSrc() {
      int n = stack.length;
      for (int i = 0; i < n; i++) {
        stack[i] = n - i;
      }
      top = n - 1;
      return this;
    }

    boolean isEmpty() {
      return top < 0;
    }

    int peek() {
      return stack[top];
    }

    void moveTopTo(Tower t) throws IOException {
      t.stack[++t.top] = this.stack[this.top--];
      bw.write("\n" + this.name + " " + t.name);
    }
  }

  static void moveDiskBetween(Tower t1, Tower t2) throws IOException {
    if (t1.isEmpty()) {
      t2.moveTopTo(t1);
    } else if (t2.isEmpty()) {
      t1.moveTopTo(t2);
    } else if (t1.peek() < t2.peek()) {
      t1.moveTopTo(t2);
    } else if (t1.peek() > t2.peek()) {
      t2.moveTopTo(t1);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    BigInteger totalMoves = BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE);
    bw.write(totalMoves.toString());
    if (n > 20) {
      bw.flush();
      bw.close();
      return;
    }

    Tower src = new Tower(n, '1').initializeSrc();
    Tower aux = new Tower(n, '2');
    Tower dest = new Tower(n, '3');

    if (n % 2 == 1) {
      Tower temp = dest;
      dest = aux;
      aux = temp;
    }
    for (int i = 0; i < totalMoves.intValue(); i++) {
      if (i % 3 == 0) {
        moveDiskBetween(src, aux);
      } else if (i % 3 == 1) {
        moveDiskBetween(src, dest);
      } else if (i % 3 == 2) {
        moveDiskBetween(aux, dest);
      }
    }

    bw.flush();
    bw.close();
  }
}
