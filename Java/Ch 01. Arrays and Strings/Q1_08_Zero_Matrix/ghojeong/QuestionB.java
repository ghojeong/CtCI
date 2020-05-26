package Q1_08_Zero_Matrix.ghojeong;

public class QuestionB {
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
    boolean rowHasZero = false;
    boolean colHasZero = false;

    // Check if first row has a zero
    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    // Check if first column has a zero
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    // Check for zeros in the rest of the array
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // Nullify rows based on values in first column
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }

    // Nullify columns based on values in first row
    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        nullifyColumn(matrix, j);
      }
    }

    // Nullify first row
    if (rowHasZero) {
      nullifyRow(matrix, 0);
    }

    // Nullify first column
    if (colHasZero) {
      nullifyColumn(matrix, 0);
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
