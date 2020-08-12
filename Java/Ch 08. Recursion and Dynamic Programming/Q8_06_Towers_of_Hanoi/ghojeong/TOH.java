package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

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

    void push(int item) {
      if (top + 1 < stack.length) {
        stack[++top] = item;
      }
    }

    int pop() {
      if (top < 0) {
        return Integer.MIN_VALUE;
      }
      return stack[top--];
    }
  }

  static void moveDisk(char fromPeg, char toPeg, int disk) throws IOException {
    bw.write("\n" + fromPeg + " " + toPeg);
  }

  static void moveDisksBetweenTwoPoles(Tower src, Tower dest, char s, char d) throws IOException {
    int pole1TopDisk = src.pop();
    int pole2TopDisk = dest.pop();

    // When pole 1 is empty
    if (pole1TopDisk == Integer.MIN_VALUE) {
      src.push(pole2TopDisk);
      moveDisk(d, s, pole2TopDisk);
    }
    // When pole2 pole is empty
    else if (pole2TopDisk == Integer.MIN_VALUE) {
      dest.push(pole1TopDisk);
      moveDisk(s, d, pole1TopDisk);
    }
    // When top disk of pole1 > top disk of pole2
    else if (pole1TopDisk > pole2TopDisk) {
      src.push(pole1TopDisk);
      src.push(pole2TopDisk);
      moveDisk(d, s, pole2TopDisk);
    }
    // When top disk of pole1 < top disk of pole2
    else {
      dest.push(pole2TopDisk);
      dest.push(pole1TopDisk);
      moveDisk(s, d, pole1TopDisk);
    }
  }

  static void tohIterative(int num_of_disks, Tower src, Tower aux, Tower dest) throws IOException {
    int i, total_num_of_moves;
    char s = '1', a = '2', d = '3';

    // If number of disks is even, then interchange dest and aux
    if (num_of_disks % 2 == 0) {
      char temp = d;
      d = a;
      a = temp;
    }
    total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

    // Larger disks will be pushed first
    for (i = num_of_disks; i >= 1; i--) {
      src.push(i);
    }

    for (i = 1; i <= total_num_of_moves; i++) {
      if (i % 3 == 1) {
        moveDisksBetweenTwoPoles(src, dest, s, d);
      } else if (i % 3 == 2) {
        moveDisksBetweenTwoPoles(src, aux, s, a);
      } else if (i % 3 == 0) {
        moveDisksBetweenTwoPoles(aux, dest, a, d);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(Integer.toString((1 << n) - 1));
    Tower src = new Tower(n, '1');
    Tower aux = new Tower(n, '2');
    Tower dest = new Tower(n, '3');
    tohIterative(n, src, aux, dest);

    bw.flush();
    bw.close();
  }
}
