package Q2_01_Remove_Dups;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

public class Gho {
  private static <T> LinkedList<T> deleteDups(LinkedList<T> ll) {
    HashSet<T> set = new HashSet<T>();
    Iterator<T> itr = ll.iterator();
    while (itr.hasNext()) { // O(n)
      T val = itr.next();
      if (set.contains(val)) { // O(1)
        itr.remove(); // O(1)
      } else {
        set.add(val);
      }
    }
    return ll;
  }

  public static void main(String[] args) {
    LinkedList<Character> ll = new LinkedList<Character>();
    Random random = new Random();
    for (int i = 1; i < 100; i++) {
      ll.add((char) (random.nextInt(20) + 63));
    }
    System.out.println(ll.toString());
    System.out.println();
    System.out.print(deleteDups(ll).toString());
  }
}
