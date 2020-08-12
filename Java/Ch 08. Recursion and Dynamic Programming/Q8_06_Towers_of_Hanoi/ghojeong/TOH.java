package Q8_06_Towers_of_Hanoi.ghojeong;

import java.io.*;

public class TOH {
  class Stack {
    int capacity;
    int top;
    int array[];
  }

  Stack createStack(int capacity) {
    Stack stack = new Stack();
    stack.capacity = capacity;
    stack.top = -1;
    stack.array = new int[capacity];
    return stack;
  }

  boolean isFull(Stack stack) {
    return (stack.top == stack.capacity - 1);
  }

  boolean isEmpty(Stack stack) {
    return (stack.top == -1);
  }

  void push(Stack stack, int item) {
    if (isFull(stack))
      return;
    stack.array[++stack.top] = item;
  }

  int pop(Stack stack) {
    if (isEmpty(stack))
      return Integer.MIN_VALUE;
    return stack.array[stack.top--];
  }

  void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
    int pole1TopDisk = pop(src);
    int pole2TopDisk = pop(dest);

    // When pole 1 is empty
    if (pole1TopDisk == Integer.MIN_VALUE) {
      push(src, pole2TopDisk);
      moveDisk(d, s, pole2TopDisk);
    }
    // When pole2 pole is empty
    else if (pole2TopDisk == Integer.MIN_VALUE) {
      push(dest, pole1TopDisk);
      moveDisk(s, d, pole1TopDisk);
    }
    // When top disk of pole1 > top disk of pole2
    else if (pole1TopDisk > pole2TopDisk) {
      push(src, pole1TopDisk);
      push(src, pole2TopDisk);
      moveDisk(d, s, pole2TopDisk);
    }
    // When top disk of pole1 < top disk of pole2
    else {
      push(dest, pole2TopDisk);
      push(dest, pole1TopDisk);
      moveDisk(s, d, pole1TopDisk);
    }
  }

  void moveDisk(char fromPeg, char toPeg, int disk) {
    System.out.println("Move the disk " + disk + " from " + fromPeg + " to " + toPeg);
  }

  void tohIterative(int num_of_disks, Stack src, Stack aux, Stack dest) {
    int i, total_num_of_moves;
    char s = 'S', d = 'D', a = 'A';

    // If number of disks is even, then interchange dest and aux
    if (num_of_disks % 2 == 0) {
      char temp = d;
      d = a;
      a = temp;
    }
    total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

    // Larger disks will be pushed first
    for (i = num_of_disks; i >= 1; i--)
      push(src, i);

    for (i = 1; i <= total_num_of_moves; i++) {
      if (i % 3 == 1)
        moveDisksBetweenTwoPoles(src, dest, s, d);

      else if (i % 3 == 2)
        moveDisksBetweenTwoPoles(src, aux, s, a);

      else if (i % 3 == 0)
        moveDisksBetweenTwoPoles(aux, dest, a, d);
    }
  }

  public static void main(String[] args) {

    int num_of_disks = 3;

    TOH ob = new TOH();
    Stack src, dest, aux;

    src = ob.createStack(num_of_disks);
    dest = ob.createStack(num_of_disks);
    aux = ob.createStack(num_of_disks);

    ob.tohIterative(num_of_disks, src, aux, dest);
  }
}
