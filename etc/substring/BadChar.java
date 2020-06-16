package etc.substring;

// Boyer Moore with Bad Character Heuristic
class BadChar {

  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  static int[] badCharHeuristic(char[] pat) {
    int badChar[] = new int[256];
    for (int i = 0; i < badChar.length; i++) {
      badChar[i] = -1;
    }
    for (int i = 0; i < pat.length; i++) {
      badChar[(int) pat[i]] = i;
    }
    return badChar;
  }

  static void search(char txt[], char pat[]) {
    int txtLen = txt.length;
    int patLen = pat.length;

    int badChar[] = badCharHeuristic(pat);

    int shift = 0; // shift of the pattern with respect to text
    while (shift <= txtLen - patLen) {
      int j = patLen - 1;

      while (j >= 0 && pat[j] == txt[shift + j]) {
        j--;
      }

      if (j < 0) {
        System.out.println("Patterns occur at shift = " + shift);
        shift += max(1, patLen - badChar[txt[shift + patLen]]);
      } else {
        shift += max(1, j - badChar[txt[shift + j]]);
      }
    }
  }

  public static void main(String[] args) {
    char txt[] = "ABAAABCD".toCharArray();
    char pat[] = "ABC".toCharArray();
    search(txt, pat);
  }
}
