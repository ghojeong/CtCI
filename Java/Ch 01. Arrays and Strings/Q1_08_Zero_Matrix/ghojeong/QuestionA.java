package Q1_08_Zero_Matrix.ghojeong;

public class QuestionA {
  public static void nullifyRow(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  public static void nullifyColumn(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  public static void setZeros(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] cols = new boolean[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      if (rows[i]) {
        nullifyRow(matrix, i);
      }
    }
    for (int j = 0; j < matrix[0].length; j++) {
      if (cols[j]) {
        nullifyColumn(matrix, j);
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = Matrix.random(10, 15);
    Matrix.print(matrix);

    setZeros(matrix);

    System.out.println();
    Matrix.print(matrix);
  }
}
