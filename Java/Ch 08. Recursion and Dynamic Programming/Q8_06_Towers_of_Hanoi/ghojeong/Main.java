package Q8_06_Towers_of_Hanoi.ghojeong;

import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringBuilder sb;
  public static int cnt = 0;

  public static class Tower {
    private Stack<Integer> disks;
    private final int name;

    public Tower(int name) {
      this.disks = new Stack<Integer>();
      this.name = name;
    }

    public void add(int d) {
      if (disks.isEmpty() || disks.peek() > d) {
        disks.push(d);
      }
    }

    public void moveTopTo(Tower t) {
      int top = disks.pop();
      t.add(top);
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
    int numberOfDisks = Integer.parseInt(br.readLine());

    Tower source = new Tower(1);
    Tower buffer = new Tower(2);
    Tower destination = new Tower(3);

    /* Load up tower */
    for (int disk = numberOfDisks - 1; disk >= 0; disk--) {
      source.add(disk);
    }

    source.moveDisks(numberOfDisks, destination, buffer);

    bw.write(cnt + sb.toString());
    br.close();
    bw.flush();
    bw.close();
  }
}
