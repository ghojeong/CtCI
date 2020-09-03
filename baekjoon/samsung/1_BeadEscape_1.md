# [구슬 탈출](https://www.acmicpc.net/problem/13459)

```java
import java.io.*;

class Main {

  static BufferedWriter bw;
  static BufferedReader br;

  static void initIO() {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  static void terminateIO() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

  static int n = 0, m = 0;
  static char[][] board;
  static boolean[][][][] visited;

  static enum Direction {
    UP, RIGHT, DOWN, LEFT,
  }

  static enum RollResult {
    SUCCESS, FAIL, CONTINUE,
  }

  static class State {
    int redI, redJ, blueI, blueJ, depth;
    RollResult result;

    State(int redI, int redJ, int blueI, int blueJ, int depth, RollResult result) {
      this.redI = redI;
      this.redJ = redJ;
      this.blueI = blueI;
      this.blueJ = blueJ;
      this.depth = depth;
      this.result = result;
    }
  }

  static class Node {
    State state;
    Direction dir;
    Node next;

    Node(State state, Direction dir) {
      this.state = state;
      this.dir = dir;
    }
  }

  static Node head, tail;

  static Node queuePoll() {
    Node node = null;
    if (head != null) {
      node = head;
      head = head.next;
    }
    return node;
  }

  static void queueAdd(Node node) {
    if (head != null) {
      tail.next = node;
      tail = node;
    } else {
      head = node;
      tail = node;
    }
  }

  static void queueAdd(State state) {
    queueAdd(new Node(state, Direction.UP));
    queueAdd(new Node(state, Direction.RIGHT));
    queueAdd(new Node(state, Direction.DOWN));
    queueAdd(new Node(state, Direction.LEFT));
  }

  static State roll(Node node) {
    int redI = node.state.redI;
    int redJ = node.state.redJ;
    int blueI = node.state.blueI;
    int blueJ = node.state.blueJ;
    int depth = node.state.depth + 1;
    Direction dir = node.dir;

    int iPlus = 0;
    int jPlus = 0;

    switch (dir) {
      case UP:
        iPlus = -1;
        break;
      case RIGHT:
        jPlus = 1;
        break;
      case DOWN:
        iPlus = 1;
        break;
      case LEFT:
        jPlus = -1;
        break;
    }

    int rCount = 0;
    int bCount = 0;

    while (board[redI][redJ] == '.') {
      redI += iPlus;
      redJ += jPlus;
      rCount++;
    }

    while (board[blueI][blueJ] == '.') {
      blueI += iPlus;
      blueJ += jPlus;
      bCount++;
    }

    if (board[blueI][blueJ] == 'O') {
      return new State(redI, redJ, blueI, blueJ, depth, RollResult.FAIL);
    }

    if (board[redI][redJ] == 'O') {
      return new State(redI, redJ, blueI, blueJ, depth, RollResult.SUCCESS);
    }

    redI -= iPlus;
    redJ -= jPlus;
    blueI -= iPlus;
    blueJ -= jPlus;

    if (redI == blueI && redJ == blueJ) {
      if (rCount > bCount) {
        redI -= iPlus;
        redJ -= jPlus;
      } else {
        blueI -= iPlus;
        blueJ -= jPlus;
      }
    }

    return new State(redI, redJ, blueI, blueJ, depth, RollResult.CONTINUE);
  }

  public static void main(String[] args) throws IOException {
    initIO();
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    board = new char[n][m];

    visited = new boolean[n][m][n][m];
    int redI = 0, redJ = 0, blueI = 0, blueJ = 0;

    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        switch (board[i][j]) {
          case 'R':
            redI = i;
            redJ = j;
            board[i][j] = '.';
            break;
          case 'B':
            blueI = i;
            blueJ = j;
            board[i][j] = '.';
            break;
        }
      }
    }

    visited[redI][redJ][blueI][blueJ] = true;
    State initialState = new State(redI, redJ, blueI, blueJ, 0, RollResult.CONTINUE);
    queueAdd(initialState);

    Node node = queuePoll();
    while (node != null) {
      State state = roll(node);
      if (state.depth > 10) {
        bw.write(Integer.toString(0));
        terminateIO();
        return;
      }
      if (state.result == RollResult.SUCCESS) {
        bw.write(Integer.toString(1));
        terminateIO();
        return;
      }
      if (state.result == RollResult.FAIL) {
        node = queuePoll();
        continue;
      }
      if (!visited[state.redI][state.redJ][state.blueI][state.blueJ]) {
        visited[state.redI][state.redJ][state.blueI][state.blueJ] = true;
        queueAdd(state);
      }
      node = queuePoll();
    }

    bw.write(Integer.toString(0));
    terminateIO();
  }
}
```
