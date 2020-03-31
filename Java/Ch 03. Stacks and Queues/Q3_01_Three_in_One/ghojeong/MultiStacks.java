package Q3_01_Three_in_One.ghojeong;

import java.util.Arrays;
import java.util.ArrayList;

public class MultiStacks<T> {

  private T[] array;
  private int lastArrIdx = 0; // array에 element가 들어가있는 마지막 인덱스

  // stack 에는 array의 idx를 저장한다.
  private ArrayList<Stack<Integer>> stacks;

  public MultiStacks(int numOfStacks, T[] array) {
    // TODO:
    this.array = array;
    if (numOfStacks < 1) {
      numOfStacks = 3;
    }
    stacks = new ArrayList<>(numOfStacks);
    for (int i = 0; i < numOfStacks; i++) {
      stacks.add(new Stack<Integer>());
    }
  }

  private boolean isAllStacksAreFull() {
    return lastArrIdx >= array.length - 1;
  }

  /*
   * Push value onto stack num, shifting/expanding stacks as necessary. Throws
   * exception if all stacks are full.
   */
  public void push(int stackNum, T value) {
    System.out.println("\n/// Pushing stack " + stackNum + ": " + value);

    if (isAllStacksAreFull()) {
      System.out.println("!!!!!!!!!!!!!!!! Array Is Full !!!!!!!!!!!!!!!!");
      return;
    }
    // TODO:
    array[lastArrIdx] = value;
    stacks.get(stackNum).push(lastArrIdx);
    lastArrIdx++;
  }

  /* Get top element of stack. */
  public T peek(int stackNum) {
    System.out.println("\n/// Peeking stack " + stackNum);

    // TODO:
    int idx = stacks.get(stackNum).peek();
    return array[idx];
  }

  /* Remove value from stack. */
  public T pop(int stackNum) throws Exception {
    System.out.println("\n/// Popping stack " + stackNum);

    // TODO:
    int idx = stacks.get(stackNum).pop();
    T value = array[idx];
    lastArrIdx--;
    return value;
  }

  public String stackToString(int stackNum) {
    ArrayList<Integer> stack = stacks.get(stackNum).toArrayList();
    String str = stackNum + ": ";
    if (stack.size() < 1) {
      return str + "[]";
    }
    str += "[" + array[stack.get(0)];
    for (int i = 1; i < stack.size(); i++) {
      str += ", " + array[stack.get(i)];
    }
    return str + "]";
  }

  public String toString() {
    String stacksStr = "";
    for (int i = 0; i < stacks.size(); i++) {
      stacksStr += stackToString(i) + "\n";
    }
    return stacksStr + "ArrayS: " + Arrays.toString(array);
  }
}
