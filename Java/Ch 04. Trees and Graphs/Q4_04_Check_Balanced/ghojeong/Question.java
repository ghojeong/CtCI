package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;

public class Question {

  public static void main(String[] args) {
    TreeNode bbtRoot = TreeFactory.getBBT(20);
    TreeNode ubtRoot = TreeFactory.getUBT(20);

    CheckBalanced bfs = new BfsCheckBalanced();
    CheckBalanced bfs2 = new Bfs2CheckBalanced();
    CheckBalanced dfs = new DfsCheckBalanced();
    CheckBalanced dfs2 = new Dfs2CheckBalanced();
    System.out.println("BFS Is balanced? " + bfs.isBalanced(bbtRoot));
    System.out.println("BFS2 Is balanced? " + bfs2.isBalanced(bbtRoot));
    System.out.println("DFS Is balanced? " + dfs.isBalanced(bbtRoot));
    System.out.println("DFS2 Is balanced? " + dfs2.isBalanced(bbtRoot));
    System.out.println("\n");
    System.out.println("BFS Is balanced? " + bfs.isBalanced(ubtRoot));
    System.out.println("BFS2 Is balanced? " + bfs2.isBalanced(ubtRoot));
    System.out.println("DFS Is balanced? " + dfs.isBalanced(ubtRoot));
    System.out.println("DFS2 Is balanced? " + dfs2.isBalanced(ubtRoot));
  }

}
