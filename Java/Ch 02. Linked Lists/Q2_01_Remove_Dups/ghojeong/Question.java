package Q2_01_Remove_Dups.ghojeong;

import java.util.Random;

public class Question {

  public static void main(String[] args) {
    LinkedList<Character> ll = new LinkedList<Character>();
    Random random = new Random();
    for (int i = 1; i < 100; i++) {
      ll.add((char) (random.nextInt(20) + 63));
    }
    System.out.println(ll);
    ll.deleteDups();
    System.out.println(ll);
  }
}
