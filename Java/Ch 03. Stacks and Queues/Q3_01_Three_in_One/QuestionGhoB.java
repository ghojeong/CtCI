package Q3_01_Three_in_One;

public class QuestionGhoB {

  public static void main(String[] args) throws Exception {
    GhoMultiStack stacks = new GhoMultiStack(3, 4);
    System.out.println(stacks);
    stacks.push(0, 10);
    System.out.println(stacks);
    stacks.push(1, 20);
    System.out.println(stacks);
    stacks.push(2, 30);
    System.out.println(stacks);

    stacks.push(1, 21);
    System.out.println(stacks);
    stacks.push(0, 11);
    System.out.println(stacks);
    stacks.push(0, 12);
    System.out.println(stacks);

    stacks.pop(0);
    System.out.println(stacks);

    stacks.push(2, 31);
    System.out.println(stacks);

    stacks.push(0, 13);
    System.out.println(stacks);
    stacks.push(1, 22);
    System.out.println(stacks);

    stacks.push(2, 31);
    System.out.println(stacks);
    stacks.push(2, 32);
    System.out.println(stacks);
    stacks.push(2, 33);
    System.out.println(stacks);
    stacks.push(2, 34);
    System.out.println(stacks);

    stacks.pop(1);
    System.out.println(stacks);
    stacks.push(2, 35);
    System.out.println(stacks);
  }
}
