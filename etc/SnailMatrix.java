public class SnailMatrix {

  public static class Coordinate {
    public int xPos, yPos;

    public Coordinate(int xPos, int yPos) {
      this.xPos = xPos;
      this.yPos = yPos;
    }
  }

  public static void printSnailMatrix(int input) {
    int xPos = 0;
    int yPos = 0;
    int maxX = 0;
    int minX = 0;
    int maxY = 0;
    int minY = 0;
    int dir = 0;
    int sideLen = 1;
    int sideItr = 0;
    Coordinate[] snailCo = new Coordinate[input + 1];
    snailCo[input] = new Coordinate(0, 0);
    for (int val = input - 1; val > 0; val--) {
      if (dir == 0) {
        xPos--;
      } else if (dir == 1) {
        yPos--;
      } else if (dir == 2) {
        xPos++;
      } else if (dir == 3) {
        yPos++;
      }

      if (maxX < xPos) {
        maxX = xPos;
      }
      if (minX > xPos) {
        minX = xPos;
      }
      if (maxY < yPos) {
        maxY = yPos;
      }
      if (minY > yPos) {
        minY = yPos;
      }
      snailCo[val] = new Coordinate(xPos, yPos);

      if (sideLen <= ++sideItr) {
        if ((dir % 2) == 1) {
          sideLen++;
        }
        sideItr = 0;
        dir = (dir + 1) % 4;
      }
    }

    int[][] matrix = new int[maxY - minY + 1][maxX - minX + 1];
    for (int val = 1; val <= input; val++) {
      Coordinate co = snailCo[val];
      matrix[-co.yPos + maxY][co.xPos - minX] = val;
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf("%4d", matrix[i][j]);
      }
      System.out.println("\n");
    }
  }

  public static void main(String[] args) {
    for (int i = 1; i < 37; i++) {
      printSnailMatrix(i);

      System.out.println("\n\n");
    }
  }
}
