package etc.heap;

import java.util.PriorityQueue;

public class Main {

  public static class MaxInteger implements Comparable<MaxInteger> {
    int integer;

    public MaxInteger(int integer) {
      this.integer = integer;
    }

    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return Integer.toString(integer);
    }

    @Override
    public int compareTo(MaxInteger maxInt) {
      if (this.integer < maxInt.integer)
        return 1;
      if (this.integer > maxInt.integer)
        return -1;
      return 0;
    }
  }

  public static void main(String[] args) {
    int[] minArr = { 0, 12345678, 1, 2, 0, 0, 0, 0, 32 };
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < minArr.length; i++) {
      int val = minArr[i];
      if (val == 0) {
        if (pq.size() < 1) {
          System.out.println(0);
          continue;
        }
        System.out.println(pq.poll());
        continue;
      }
      pq.offer(val);
    }

    System.out.println();

    PriorityQueue<MaxInteger> maxpq = new PriorityQueue<MaxInteger>();
    for (int i = 0; i < minArr.length; i++) {
      int val = minArr[i];
      if (val == 0) {
        if (maxpq.size() < 1) {
          System.out.println(0);
          continue;
        }
        System.out.println(maxpq.poll());
        continue;
      }
      maxpq.offer(new MaxInteger(val));
    }
  }

}
