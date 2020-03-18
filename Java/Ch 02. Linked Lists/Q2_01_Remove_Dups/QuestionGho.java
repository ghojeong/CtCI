package Q2_01_Remove_Dups;

import java.util.Random;

public class QuestionGho {

  public static void main(String[] args) {
    GhoLinkedList<Character> ll = new GhoLinkedList<Character>();
    Random random = new Random();
    for (int i = 1; i < 100; i++) {
      ll.add((char) (random.nextInt(20) + 63));
    }
    System.out.println(ll);
    ll.deleteDups();
    System.out.print(ll);
  }
}
