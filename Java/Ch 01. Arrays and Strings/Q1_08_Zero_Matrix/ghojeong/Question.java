package Q1_08_Zero_Matrix.ghojeong;

public class Question {
  public static int[][] randomMatrix(int rowM, int colN) {
    int[][] matrix = new int[rowM][colN];
    for (int i = 0; i < rowM; i++) {
      for (int j = 0; j < colN; j++) {
        matrix[i][j] = 20 - (int) (Math.random() * 40);
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
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
    int[][] matrix = randomMatrix(10, 15);
    printMatrix(matrix);

    setZeros(matrix);

    System.out.println();
    printMatrix(matrix);
  }
}
