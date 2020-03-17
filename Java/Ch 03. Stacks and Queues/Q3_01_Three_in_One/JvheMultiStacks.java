package Q3_01_Three_in_One;

import java.util.Arrays;
import java.util.ArrayList;

public class JvheMultiStacks<T> {

  private T[] array;

  // stack 에는 array의 idx를 저장한다.
  private class Stack {
    public int start; // stack의 시작 idx
    public int top = -1; // 실제 element가 들어있는 idx
    public int capacity;

    Stack(int start, int capacity) {
      this.start = start;
      this.top = start - 1;
      this.capacity = capacity;
    }

    public void push(T value) {
      if (capacity - 2 < top - start) {
        System.out.println("!!!!!!!!!!!!!!!! Stack Is Full !!!!!!!!!!!!!!!!");
        return;
      }
      array[++top] = value;
    }

    public T peek() {
      return array[top];
    }

    public T pop() {
      T value = array[top];
      array[top--] = null;
      return value;
    }

    public String toString() {
      if (top < start) {
        return "[]";
      }
      String str = "[" + array[start];
      for (int i = start; i < start + capacity; i++) {
        str += ", " + array[i];
      }
      return str + "]";
    }
  }

  private Stack stack0;
  private Stack stack1;
  private Stack stack2;

  public JvheMultiStacks(T[] array) {
    // TODO:
    this.array = array;
    int length = array.length;
    stack0 = new Stack(0, length / 3);
    stack1 = new Stack(length / 3, length / 3);
    stack2 = new Stack(2 * length / 3, length / 3);
  }

  /*
   * Push value onto stack num, shifting/expanding stacks as necessary. Throws
   * exception if all stacks are full.
   */
  public void push(int stackNum, T value) {
    System.out.println("\n/// Pushing stack " + stackNum + ": " + value);

    // TODO:
    if (stackNum == 0) {
      stack0.push(value);
    }
    if (stackNum == 1) {
      stack1.push(value);
    }
    if (stackNum == 2) {
      stack2.push(value);
    }
  }

  /* Get top element of stack. */
  public T peek(int stackNum) {
    System.out.println("\n/// Peeking stack " + stackNum);

    // TODO:
    if (stackNum == 0) {
      return stack0.peek();
    }
    if (stackNum == 1) {
      return stack1.peek();
    }
    if (stackNum == 2) {
      return stack2.peek();
    }
    return null;
  }

  /* Remove value from stack. */
  public T pop(int stackNum) {
    System.out.println("\n/// Popping stack " + stackNum);

    if (stackNum == 0) {
      return stack0.pop();
    }
    if (stackNum == 1) {
      return stack1.pop();
    }
    if (stackNum == 2) {
      return stack2.pop();
    }
    return null;
  }

  // public String stackToString(int stackNum) {
  // ArrayList<Integer> stack = stacks.get(stackNum).toArrayList();
  // String str = stackNum + ": ";
  // if (stack.size() < 1) {
  // return str + "[]";
  // }
  // str += "[" + array[stack.get(0)];
  // for (int i = 1; i < stack.size(); i++) {
  // str += ", " + array[stack.get(i)];
  // }
  // return str + "]";
  // }

  public String toString() {
    String str = 0 + ": " + stack0;
    str += "\n" + 1 + ": " + stack1;
    str += "\n" + 2 + ": " + stack2;
    return str + "\nArrayS: " + Arrays.toString(array);
  }
}
