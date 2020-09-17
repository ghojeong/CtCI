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
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int pathNum = 0;

    int oldH = board[0][0];
    int oldCnt = 0;

    for (int i = 0; i < n; i++) {
      oldH = board[i][0];
      oldCnt = 0;
      for (int j = 0; j < n; j++) {
        int newH = board[i][j];
        if (Math.abs(newH - oldH) > 1) {
          break;
        }
        if (newH == oldH) {
          oldCnt++;
        } else {
          if (newH > oldH) {
            if (oldCnt < l) {
              break;
            }
            oldCnt = 1;
          } else {
            if (j + l > n) {
              break;
            }
            boolean isAble = true;
            for (int k = 1; k < l; k++) {
              if (newH != board[i][j + k]) {
                isAble = false;
                break;
              }
            }
            if (!isAble) {
              break;
            }
            j += l - 1;
            oldCnt = 0;
          }
        }
        if (j == n - 1) {
          // System.out.println("-> " + i);
          pathNum++;
        }
        oldH = newH;
      }
    }

    for (int j = 0; j < n; j++) {
      oldH = board[0][j];
      oldCnt = 0;
      for (int i = 0; i < n; i++) {
        int newH = board[i][j];
        if (Math.abs(newH - oldH) > 1) {
          break;
        }
        if (newH == oldH) {
          oldCnt++;
        } else {
          if (newH > oldH) {
            if (oldCnt < l) {
              break;
            }
            oldCnt = 1;
          } else {
            if (i + l > n) {
              break;
            }
            boolean isAble = true;
            for (int k = 1; k < l; k++) {
              if (newH != board[i + k][j]) {
                isAble = false;
                break;
              }
            }
            if (!isAble) {
              break;
            }
            i += l - 1;
            oldCnt = 0;
          }
        }
        if (i == n - 1) {
          // System.out.println("Up " + j);
          pathNum++;
        }
        oldH = newH;
      }
    }

    bw.write(Integer.toString(pathNum));
    closeIO();
  }
}
