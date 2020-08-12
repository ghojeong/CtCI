package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class Main {
  public static BufferedReader br;
  public static BufferedWriter bw;

  public static class Tower {
    private int[] diskStack;
    private int top = 0;
    private final char name;

    public Tower(char name, int size) {
      this.diskStack = new int[size];
      this.name = name;
    }

    private void moveTopTo(Tower t) {
      if (t.top + 1 < t.diskStack.length && this.top > 0 && t.diskStack[t.top] > this.diskStack[this.top]) {
        t.diskStack[++t.top] = this.diskStack[this.top--];
      }
    }

    public void moveDisks(int n, Tower dest, Tower aux) throws IOException {
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

    Tower src = new Tower('1', n);
    Tower aux = new Tower('2', n);
    Tower dest = new Tower('3', n);

    for (int i = 0; i < n; i++) {
      src.diskStack[i] = n - i;
    }
    src.top = n - 1;

    bw.write(Integer.toString((1 << n) - 1));
    src.moveDisks(n, dest, aux);

    bw.flush();
    bw.close();
  }
}
