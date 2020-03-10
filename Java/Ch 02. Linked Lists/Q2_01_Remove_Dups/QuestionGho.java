package Q2_01_Remove_Dups;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

public class QuestionGho {
  private static LinkedList<Integer> deleteDups(LinkedList<Integer> ll) {
    LinkedList<Integer> deletedLl = new LinkedList<Integer>();
    HashSet<Integer> set = new HashSet<Integer>();
    Iterator<Integer> itr = ll.iterator();
    while (itr.hasNext()) {
      int val = itr.next();
      if (!set.contains(val)) {
        set.add(val);
        deletedLl.add(val);
      }
    }
    return deletedLl;
  }

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    Random random = new Random();
    for (int i = 1; i < 100; i++) {
      ll.add(random.nextInt(50));
    }
    System.out.println(ll.toString());
    System.out.println();
    System.out.print(deleteDups(ll).toString());
  }
}
