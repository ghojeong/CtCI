package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class Main {
  public static BufferedReader br;
  public static BufferedWriter bw;
  public static int n;

  public static class Tower {
    private int[] diskStack;
    private int top = 0;
    private final int name;

    public Tower(int name) {
      this.diskStack = new int[n];
      this.name = name;
    }

    private void moveTopTo(Tower t) {
      if (t.top < n - 1 && this.top > 0 && t.diskStack[t.top] > this.diskStack[this.top]) {
        t.diskStack[++t.top] = this.diskStack[this.top--];
      }
    }

    public void moveDisks(int quantity, Tower destination, Tower buffer) throws IOException {
      if (quantity <= 0) {
        return;
      }
      moveDisks(quantity - 1, buffer, destination);
      bw.write("\n" + this.name + " " + destination.name);
      bw.flush();
      moveTopTo(destination);
      buffer.moveDisks(quantity - 1, destination, this);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Tower source = new Tower(1);
    Tower buffer = new Tower(2);
    Tower destination = new Tower(3);

    for (int i = 0; i < n; i++) {
      source.diskStack[i] = n - i;
    }
    source.top = n - 1;

    bw.write(Integer.toString((1 << n) - 1));
    source.moveDisks(n, destination, buffer);

    bw.flush();
    bw.close();
  }
}
