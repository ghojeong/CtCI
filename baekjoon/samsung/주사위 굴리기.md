# [주사위 굴리기](https://www.acmicpc.net/problem/14499)

```java
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

  static class Dice {
    int x, y;
    int[][] board;
    int[] faces;

    public Dice(int x, int y, int[][] board) {
      this.x = x;
      this.y = y;
      this.board = board;

      // 0:아래, 5:위
      // 1,2,3,4:동서북남
      this.faces = new int[6];
    }

    // 굴렸을 때 지도 바깥으로 이동하면 false
    boolean roll(int dir) {

      // System.out.println("\n\n" + dir);

      if (dir == 1) { // 동
        y++;
      } else if (dir == 2) { // 서
        y--;
      } else if (dir == 3) { // 북
        x--;
      } else if (dir == 4) { // 남
        x++;
      }

      if (y < 0) {
        y = 0;
        return false;
      }
      if (x < 0) {
        x = 0;
        return false;
      }
      if (y >= board[0].length) {
        y = board[0].length - 1;
        return false;
      }
      if (x >= board.length) {
        x = board.length - 1;
        return false;
      }

      int[] newFaces = Arrays.copyOf(faces, faces.length);
      newFaces[0] = faces[dir];
      newFaces[dir] = faces[5];
      if (dir == 1) { // 동
        newFaces[5] = faces[2];
        newFaces[2] = faces[0];
      } else if (dir == 2) { // 서
        newFaces[5] = faces[1];
        newFaces[1] = faces[0];
      } else if (dir == 3) { // 북
        newFaces[5] = faces[4];
        newFaces[4] = faces[0];
      } else if (dir == 4) { // 남
        newFaces[5] = faces[3];
        newFaces[3] = faces[0];
      }
      faces = newFaces;

      if (board[x][y] == 0) {
        board[x][y] = faces[0];
      } else {
        faces[0] = board[x][y];
        board[x][y] = 0;
      }
      // for (int i = 0; i < board.length; i++) {
      // System.out.println(Arrays.toString(board[i]));
      // }
      // System.out.println(Arrays.toString(faces));
      return true;
    }
  }

  public static void main(String[] args) throws IOException {
    initIO();

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    Dice dice = new Dice(x, y, board);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      int cmd = Integer.parseInt(st.nextToken());
      if (dice.roll(cmd)) {
        bw.write(dice.faces[5] + "\n");
      }
    }

    closeIO();
  }
}
```
