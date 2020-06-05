package etc.substring;

import java.util.Scanner;

public class Main {

  public static void main(String[] a) {

    Scanner scan = new Scanner(System.in);
    String str, subStr;
    SearchInterface def = new SearchDefault();
    SearchInterface brute = new SearchBruteForce();
    SearchInterface kmp = new SearchKMP();
    SearchInterface boyer = new SearchBoyerMoore();

    for (int i = 0; i < 5; i++) {
      try {
        System.out.print("\nstr:    ");
        str = scan.nextLine();
        System.out.print("subStr: ");
        subStr = scan.nextLine();

        System.out.println("Default: " + def.search(str, subStr));
        System.out.println("BruteForce: " + brute.search(str, subStr));
        System.out.println("KMP: " + kmp.search(str, subStr));
        System.out.println("Boyer-Moore: " + boyer.search(str, subStr));
      } catch (Exception e) {
        System.out.println(e + "\n");
      }
    }
    scan.close();
  }
}
