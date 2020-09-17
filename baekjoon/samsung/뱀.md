# [뱀](https://www.acmicpc.net/problem/3190)

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

  static enum Direction {
    UP, RIGHT, DOWN, LEFT
  }

  static class Coordinate {
    int i, j;

    public Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  static int n = 0;
  static int[][] board; // false: 빈칸, true: 사과
  static LinkedList<Coordinate> snake;
  static Direction dir = Direction.RIGHT;
  static int time = 0;

  public static void main(String[] args) throws IOException {
    initIO();

    n = Integer.parseInt(br.readLine());
    board = new int[n][n]; // 1:사과, 2:몸통
    snake = new LinkedList<Coordinate>();
    snake.offerFirst(new Coordinate(0, 0));
    board[0][0] = 2;

    int appleNum = Integer.parseInt(br.readLine());
    for (int i = 0; i < appleNum; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int appleI = Integer.parseInt(st.nextToken()) - 1;
      int appleJ = Integer.parseInt(st.nextToken()) - 1;
      board[appleI][appleJ] = 1;
    }

    int rotateNum = Integer.parseInt(br.readLine());
    int[] rotateTime = new int[rotateNum];
    char[] rotateDir = new char[rotateNum];
    for (int i = 0; i < rotateNum; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      rotateTime[i] = Integer.parseInt(st.nextToken());
      rotateDir[i] = st.nextToken().charAt(0);
    }

    int idx = 0;
    for (time = 1;; time++) {

      // System.out.println("\ntime:" + time);
      // for (int i = 0; i < n; i++) {
      // System.out.println(Arrays.toString(board[i]));
      // }

      Coordinate snakeHead = snake.getFirst();
      int headI = snakeHead.i;
      int headJ = snakeHead.j;
      if (dir == Direction.UP) {
        headI--;
      } else if (dir == Direction.RIGHT) {
        headJ++;
      } else if (dir == Direction.DOWN) {
        headI++;
      } else if (dir == Direction.LEFT) {
        headJ--;
      }

      if (headI < 0 || headJ < 0 || headI >= n || headJ >= n) {
        break;
      }
      if (board[headI][headJ] == 2) { // 몸통인 경우
        break;
      } else if (board[headI][headJ] == 0) { // 사과가 아닌 경우
        Coordinate snakeTail = snake.pollLast();
        board[snakeTail.i][snakeTail.j] = 0;
      }
      snake.offerFirst(new Coordinate(headI, headJ));
      board[headI][headJ] = 2;

      if (idx < rotateNum && rotateTime[idx] == time) {
        if (rotateDir[idx] == 'D') {
          if (dir == Direction.UP) {
            dir = Direction.RIGHT;
          } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
          } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
          } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
          }
        } else if (rotateDir[idx] == 'L') {
          if (dir == Direction.UP) {
            dir = Direction.LEFT;
          } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
          } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
          } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
          }
        }
        idx++;
      }

    }

    bw.write(Integer.toString(time));
    closeIO();
  }
}
```
