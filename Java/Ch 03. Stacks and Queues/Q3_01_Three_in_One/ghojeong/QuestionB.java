package Q3_01_Three_in_One.ghojeong;

import java.util.Arrays;

public class QuestionB {

  public static void main(String[] args) throws Exception {
    MultiStack stacks = new MultiStack(3, 4);

    System.out.println(stacks);

    System.out.println("\n############ 1 ############");
    stacks.push(0, 10);
    System.out.println(stacks);
    stacks.push(1, 20);
    System.out.println(stacks);
    stacks.push(2, 30);
    System.out.println(stacks);

    System.out.println("\n############ 2 ############");
    stacks.push(1, 21);
    System.out.println(stacks);
    stacks.push(0, 11);
    System.out.println(stacks);
    stacks.push(0, 12);
    System.out.println(stacks);

    System.out.println("\n############ 3 ############");
    stacks.pop(0);
    System.out.println(stacks);

    System.out.println("\n############ 4 ############");
    stacks.push(2, 31);
    System.out.println(stacks);

    System.out.println("\n############ 5 ############");
    stacks.push(0, 13);
    System.out.println(stacks);
    stacks.push(1, 22);
    System.out.println(stacks);

    System.out.println("\n############ 6 ############");
    stacks.push(2, 31);
    System.out.println(stacks);
    stacks.push(2, 32);
    System.out.println(stacks);
    stacks.push(2, 33);
    System.out.println(stacks);
    stacks.push(2, 34);
    System.out.println(stacks);

    System.out.println("\n############ 7 ############");
    stacks.pop(1);
    System.out.println(stacks);
    stacks.push(2, 35);
    System.out.println(stacks);

    System.out.println("\nFinal Stack: " + Arrays.toString(stacks.getValues()));
  }
}
