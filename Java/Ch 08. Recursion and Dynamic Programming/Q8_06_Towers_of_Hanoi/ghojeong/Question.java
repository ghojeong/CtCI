package Q8_06_Towers_of_Hanoi.ghojeong;

import java.util.Stack;

public class Question {
  public static class Tower {
    private Stack<Integer> disks = new Stack<Integer>();
    public String name;

    public void add(int d) {
      if (!disks.isEmpty() && disks.peek() <= d) {
        System.out.println("Error placing disk " + d);
      } else {
        disks.push(d);
      }
    }

    public void moveTopTo(Tower t) {
      int top = disks.pop();
      t.add(top);
    }

    public void print() {
      System.out.println("Contents of Tower " + name + ": " + disks.toString());
    }

      public void moveDisks(int quantity, Tower destination, Tower buffer){
        if (quantity <= 0) return;

      moveDisks(quantity - 1, buffer, destination);
      System.out.println("Move " + disks.peek() + " from " + this.name + " to " + destination.name);
      moveTopTo(destination);
      buffer.moveDisks(quantity - 1, destination, this);
    }
  }

	public static void main(String[] args) {
		Tower source = new Tower();
		Tower destination = new Tower();
		Tower buffer = new Tower();

		source.name = "s";
		destination.name = "d";
		buffer.name = "b";

		/* Load up tower */
		int numberOfDisks = 5;
		for (int disk = numberOfDisks - 1; disk >= 0; disk--) {
			source.add(disk);
		}

		source.print();
		source.moveDisks(numberOfDisks, destination, buffer);
		destination.print();
	}
}
