package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

class GFG {
  private static BufferedReader br;
  private static BufferedWriter bw;

  private static void towerOfHanoi(int n, char src, char aux, char dest) throws IOException {
    if (n < 2) {
      bw.write("\n" + src + " " + dest);
      return;
    }
    towerOfHanoi(n - 1, src, dest, aux);
    bw.write("\n" + src + " " + dest);
    bw.flush();
    towerOfHanoi(n - 1, aux, src, dest);
  }

  public static void main(String args[]) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(Integer.toString((1 << n) - 1));
    towerOfHanoi(n, '1', '2', '3');

    bw.flush();
    bw.close();
  }
}
