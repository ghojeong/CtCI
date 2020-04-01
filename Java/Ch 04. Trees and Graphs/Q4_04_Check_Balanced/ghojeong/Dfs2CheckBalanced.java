package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;

public class Dfs2CheckBalanced implements CheckBalanced {
  private int maxDepth;
  private int minDepth;
  private LinkedList<TreeNode> visitingList;

  private void initialize() {
    this.maxDepth = 0;
    this.minDepth = 0;
    this.visitingList = new LinkedList<TreeNode>();
  }

  private void checkBalance(TreeNode root) {
    initialize();
    int depth = 0;
    visitingList.add(root);
    while (!visitingList.isEmpty()) {
      depth++;
      int size = visitingList.size();
      for (int width = 0; width < size; width++) {
        TreeNode node = visitingList.removeFirst();
        if (node.left == null && node.right == null) {
          if (minDepth == 0 || minDepth > depth) {
            minDepth = depth;
          }
          if (maxDepth < depth) {
            maxDepth = depth;
          }
        }
        if (node.left != null) {
          visitingList.add(node.left);
        }
        if (node.right != null) {
          visitingList.add(node.right);
        }
      }
    }
  }

  public boolean isBalanced(TreeNode root) {
    initialize();
    checkBalance(root);

    System.out.println("\nmaxDepth:" + maxDepth + ", minDepth:" + minDepth);

    return maxDepth - minDepth < 2;
  }
}
