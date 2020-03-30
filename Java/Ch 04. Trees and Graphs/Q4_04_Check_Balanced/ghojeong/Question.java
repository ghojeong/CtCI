package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;

public class Question {

  public static void main(String[] args) {
    TreeNode bbtRoot = TreeFactory.getBBT(20);
    TreeNode ubtRoot = TreeFactory.getUBT(20);

    CheckBalanced bfs = new BFS();
    CheckBalanced dfs = new DFS();
    System.out.println("BFS Is balanced? " + bfs.isBalanced(bbtRoot));
    System.out.println("DFS Is balanced? " + dfs.isBalanced(bbtRoot));
    System.out.println("\n");
    System.out.println("BFS Is balanced? " + bfs.isBalanced(ubtRoot));
    System.out.println("DFS Is balanced? " + dfs.isBalanced(ubtRoot));
  }

}
