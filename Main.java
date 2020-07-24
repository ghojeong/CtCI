import java.util.*;
import java.io.*;

class Main {

  public static long hashCode(String str) {
    char[] charArr = str.toCharArray();
    long hashVal = 0;
    for (int ch : charArr) {
      // System.out.println(ch - 97);
      hashVal |= 1 << (ch - 97);
    }
    // System.out.println(Integer.toBinaryString(hashVal));
    return hashVal;
  }

  public static void main(String[] args) {
    hashCode("abdg");
  }

  // public List<List<String>> groupAnagrams(String[] strs) {

  // }
}
