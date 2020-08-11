package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

class GFG {
  public static BufferedReader br;
  public static BufferedWriter bw;

  static void towerOfHanoi(int n, int src, int buffer, int dest) throws IOException {
    if (n < 2) {
      bw.write("\n" + src + " " + dest);
      return;
    }
    towerOfHanoi(n - 1, src, dest, buffer);
    bw.write("\n" + src + " " + dest);
    bw.flush();
    towerOfHanoi(n - 1, buffer, src, dest);
  }

  public static void main(String args[]) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(Integer.toString((1 << n) - 1));
    towerOfHanoi(n, 1, 2, 3);

    bw.flush();
    bw.close();
  }
}
