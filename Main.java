import java.util.*;
import java.io.*;

class Main {
  static BufferedReader br;
  static BufferedWriter bw;

  static void initIO() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  static void closeIO() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    initIO();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[][] board = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write("-1");
    closeIO();
  }
}
