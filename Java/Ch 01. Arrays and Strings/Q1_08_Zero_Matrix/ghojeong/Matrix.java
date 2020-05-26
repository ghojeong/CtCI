package Q1_08_Zero_Matrix.ghojeong;

public class Matrix {
  public static int[][] random(int rowM, int colN) {
    int[][] matrix = new int[rowM][colN];
    for (int i = 0; i < rowM; i++) {
      for (int j = 0; j < colN; j++) {
        matrix[i][j] = 20 - (int) (Math.random() * 40);
      }
    }
    return matrix;
  }

  public static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < 10 && matrix[i][j] > -10) {
          System.out.print(" ");
        }
        if (matrix[i][j] < 100 && matrix[i][j] > -100) {
          System.out.print(" ");
        }
        if (matrix[i][j] >= 0) {
          System.out.print(" ");
        }
        System.out.print(" " + matrix[i][j]);
      }
      System.out.println();
    }
  }
}
