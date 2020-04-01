package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;
import java.util.HashMap;

public class Dfs2CheckBalanced implements CheckBalanced {
  private int maxDepth;
  private int minDepth;
  private LinkedList<TreeNode> visitingList;
  private HashMap<TreeNode, Integer> nodeToDepth;

  private void initialize() {
    this.maxDepth = 0;
    this.minDepth = 0;
    this.visitingList = new LinkedList<TreeNode>();
    this.nodeToDepth = new HashMap<TreeNode, Integer>();
  }

  private void checkBalance(TreeNode root) {
    initialize();
    nodeToDepth.put(root, 0);
    visitingList.add(root);

    while (!visitingList.isEmpty()) {
      TreeNode node = visitingList.removeLast();
      int depth = nodeToDepth.get(node);

      if (node.left == null && node.right == null) {
        if (minDepth == 0 || minDepth > depth) {
          minDepth = depth;
        }
        if (maxDepth < depth) {
          maxDepth = depth;
        }
      }

      if (node.left != null) {
        nodeToDepth.put(node.left, depth + 1);
        visitingList.add(node.left);
      }
      if (node.right != null) {
        nodeToDepth.put(node.right, depth + 1);
        visitingList.add(node.right);
      }
    }
  }

  public boolean isBalanced(TreeNode root) {
    checkBalance(root);

    System.out.println("\nmaxDepth:" + maxDepth + ", minDepth:" + minDepth);

    return maxDepth - minDepth < 2;
  }
}
