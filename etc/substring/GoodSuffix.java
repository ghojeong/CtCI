package etc.substring;

// Boyer Moore Algorithm with Good Suffix heuristic
public class GoodSuffix {

  static int[] preprocess(char[] pat) {
    int i, j, patLen = pat.length;
    int[] sArr = new int[patLen + 1];
    for (i = 0; i < sArr.length; i++) {
      sArr[i] = 0;
    }

    // bpos: border position
    // border: substring which is both proper suffice and proper prefix
    int[] bpos = new int[patLen + 1];
    i = patLen; // start of suffix
    j = patLen + 1; // border of suffix
    bpos[i] = j; // store the beginning position of border
    while (i > 0) {
      while (j <= patLen && pat[i - 1] != pat[j - 1]) {
        if (sArr[j] == 0) {
          sArr[j] = j - i;
        }
        j = bpos[j]; // Update the position of next border
      }
      // pat[i - 1] == pat[j - 1] : border is found.
      i--;
      j--;
      bpos[i] = j; // store the beginning position of border
    }

    j = bpos[0];
    for (i = 0; i <= patLen; i++) {
      // set the border position of the first character of the pattern
      // to all indices in array shift having shift[i] = 0
      if (sArr[i] == 0) {
        sArr[i] = j;
      }

      // suffix becomes shorter than bpos[0],
      // use the position of next widest border as value of j
      if (i == j) {
        j = bpos[j];
      }
    }

    return sArr;
  }

  static void search(char[] txt, char[] pat) {
    int txtLen = txt.length;
    int patLen = pat.length;

    // the distance pattern will shift, if mismatch occur at position i-1
    int[] sArr = preprocess(pat);

    int shift = 0; // shift of the pattern with respect to txt
    while (shift <= txtLen - patLen) {
      int j = patLen - 1;
      while (j >= 0 && pat[j] == txt[shift + j]) {
        j--;
      }
      if (j < 0) {
        System.out.println("pattern occurs at shift = " + shift);
        shift += sArr[0];
      } else {
        shift += sArr[j + 1];
      }
    }

  }

  public static void main(String[] args) {
    char[] txt = "ABAAAABAACD".toCharArray();
    char[] pat = "ABA".toCharArray();
    search(txt, pat);
  }
}
