package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class TOH {
  private static BufferedReader br;
  private static BufferedWriter bw;

  private static class Tower {
    private int top = 0;
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
      return top < 1;
    }

    boolean isFull() {
      return top >= stack.length - 1;
    }

    int peek() {
      return stack[top];
    }

    void moveTopTo(Tower t) throws IOException {
      if (!this.isEmpty() && !t.isFull() && this.peek() < t.peek()) {
        t.stack[++t.top] = this.stack[this.top--];
        bw.write("\n" + this.name + " " + t.name);
      }
    }
  }

  static void moveDisksBetween(Tower t1, Tower t2) throws IOException {
    if (t1.isEmpty()) {
      t1.moveTopTo(t2);
    } else if (t2.isEmpty()) {
      t2.moveTopTo(t1);
    } else if (t1.peek() > t2.peek()) {
      t2.moveTopTo(t1);
    } else if (t1.peek() < t2.peek()) {
      t1.moveTopTo(t2);
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

    if (n % 2 == 0) {
      Tower temp = dest;
      dest = aux;
      aux = temp;
    }
    int totalMoves = (1 << n) - 1;
    bw.write(totalMoves);
    for (int i = 1; i <= totalMoves; i++) {
      if (i % 3 == 1) {
        moveDisksBetween(src, dest);
      } else if (i % 3 == 2) {
        moveDisksBetween(src, aux);
      } else if (i % 3 == 0) {
        moveDisksBetween(aux, dest);
      }
    }

    bw.flush();
    bw.close();
  }
}
