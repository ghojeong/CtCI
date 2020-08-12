package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class Main {
  private static BufferedReader br;
  private static BufferedWriter bw;

  private static class Tower {
    private int top = 0;
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

    private void moveTopTo(Tower t) {
      if (t.top + 1 < t.stack.length && this.top > 0 && t.stack[t.top] > this.stack[this.top]) {
        t.stack[++t.top] = this.stack[this.top--];
      }
    }

    void moveDisks(int n, Tower dest, Tower aux) throws IOException {
      if (n <= 0) {
        return;
      }
      moveDisks(n - 1, aux, dest);
      bw.write("\n" + this.name + " " + dest.name);
      bw.flush();
      moveTopTo(dest);
      aux.moveDisks(n - 1, dest, this);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Tower src = new Tower(n, '1').initializeSrc();
    Tower aux = new Tower(n, '2');
    Tower dest = new Tower(n, '3');

    bw.write(Integer.toString((1 << n) - 1));
    src.moveDisks(n, dest, aux);

    bw.flush();
    bw.close();
  }
}
