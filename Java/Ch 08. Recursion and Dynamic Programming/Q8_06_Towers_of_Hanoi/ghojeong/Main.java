package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;
import java.math.BigInteger;

public class Main {
  private static BufferedReader br;
  private static BufferedWriter bw;

  private static class Tower {
    private int top = -1;
    private int[] stack;
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

    private void moveTopTo(Tower t) throws IOException {
      t.stack[++t.top] = this.stack[this.top--];
      bw.write("\n" + this.name + " " + t.name);
    }
  }

  static void moveDisks(int n, Tower src, Tower aux, Tower dest) throws IOException {
    if (n <= 0) {
      return;
    }
    moveDisks(n - 1, src, dest, aux);
    src.moveTopTo(dest);
    moveDisks(n - 1, aux, src, dest);
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
    moveDisks(n, src, aux, dest);

    bw.flush();
    bw.close();
  }
}
