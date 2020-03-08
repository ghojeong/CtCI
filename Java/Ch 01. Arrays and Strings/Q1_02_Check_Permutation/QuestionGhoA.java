package Q1_02_Check_Permutation;

public class QuestionGhoA {

  public static char[] sortCharArray(char[] charArray) {
    for (int i = 1; i < charArray.length; i++) {
      char temp = charArray[i];
      int i2 = i - 1;

      while ((i2 >= 0) && charArray[i2] > temp) {
        charArray[i2 + 1] = charArray[i2];
        i2--;
      }
      charArray[i2 + 1] = temp;
    }
    return charArray;
  }

  public static String sort(String s) {
    char[] charArray = s.toCharArray();
    sortCharArray(charArray);
    String sortedS = new String(charArray);
    System.out.println(sortedS);
    return sortedS;
  }

  public static boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    return sort(s).equals(sort(t));
  }

  public static void main(String[] args) {
    String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" }, {
        "neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur",
        "neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur" } };
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = permutation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + anagram);
    }
  }
}
