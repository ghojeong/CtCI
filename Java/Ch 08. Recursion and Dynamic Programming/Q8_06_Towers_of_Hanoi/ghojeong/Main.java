package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringBuilder sb;
  public static int cnt = 0;
  public static int numberOfDisks;

  public static class Tower {
    private int[] diskStack;
    private int top = 0;
    private final int name;

    public Tower(int name) {
      this.diskStack = new int[numberOfDisks];
      this.name = name;
    }

    private void moveTopTo(Tower t) {
      if (t.diskStack[t.top] > this.diskStack[this.top] && this.top > 0 && t.top < numberOfDisks - 1) {
        t.diskStack[++t.top] = this.diskStack[this.top--];
      }
    }

    public void moveDisks(int quantity, Tower destination, Tower buffer) {
      if (quantity <= 0) {
        return;
      }

      moveDisks(quantity - 1, buffer, destination);
      sb.append('\n');
      sb.append(this.name);
      sb.append(' ');
      sb.append(destination.name);
      cnt++;
      moveTopTo(destination);
      buffer.moveDisks(quantity - 1, destination, this);
    }
  }

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    numberOfDisks = Integer.parseInt(br.readLine());

    Tower source = new Tower(1);
    Tower buffer = new Tower(2);
    Tower destination = new Tower(3);

    for (int i = 0; i < numberOfDisks; i++) {
      source.diskStack[i] = numberOfDisks - i;
    }
    source.top = numberOfDisks - 1;

    source.moveDisks(numberOfDisks, destination, buffer);

    bw.write(cnt + sb.toString() + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}
