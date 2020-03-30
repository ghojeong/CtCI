package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;

public class Question {

  public static void main(String[] args) {
    TreeNode bbtRoot = TreeFactory.getBBT(20);
    TreeNode ubtRoot = TreeFactory.getUBT(20);

    CheckBalanced checkBalanced = new CheckBalanced();
    System.out.println("Is balanced? " + checkBalanced.isBalanced(bbtRoot));
    System.out.println("\n");
    System.out.println("Is balanced? " + checkBalanced.isBalanced(ubtRoot));
  }

}
