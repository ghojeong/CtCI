package Q1_02_Check_Permutation;

public class GhoB {
  public static boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int min_char_s = 1000000;
    int min_char_t = 1000000;
    int max_char_s = 0;
    int max_char_t = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) > max_char_s) {
        max_char_s = s.charAt(i);
      }
      if (s.charAt(i) < min_char_s) {
        min_char_s = s.charAt(i);
      }
      if (t.charAt(i) > max_char_t) {
        max_char_t = t.charAt(i);
      }
      if (t.charAt(i) < min_char_t) {
        min_char_t = t.charAt(i);
      }
    }

    if (max_char_s != max_char_t) {
      return false;
    }
    if (min_char_s != min_char_t) {
      return false;
    }

    int offset = min_char_s;
    int counter_length = max_char_s - min_char_s + 1;

    int[] s_counter = new int[counter_length];
    int[] t_counter = new int[counter_length];
    for (int i = 0; i < s.length(); i++) {
      s_counter[s.charAt(i) - offset]++;
      t_counter[t.charAt(i) - offset]++;
    }

    for (int i = 0; i < counter_length; i++) {
      if (s_counter[i] != t_counter[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" } };
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = permutation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + anagram);
    }
  }
}
