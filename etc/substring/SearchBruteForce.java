package etc.substring;

public class SearchBruteForce implements SearchInterface {
  public int search(String str, String subStr) {
    int m = str.length();
    int n = subStr.length();
    int i, j = 0;
    for (i = 0; i < m - n; i++) {
      for (j = 0; j < n; j++) {
        if (str.charAt(i + j) != subStr.charAt(j))
          break;
      }
      if (j == n)
        return i;
    }
    return -1;
  }
}
