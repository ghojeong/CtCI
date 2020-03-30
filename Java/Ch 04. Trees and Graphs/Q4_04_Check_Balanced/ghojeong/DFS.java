package Q4_04_Check_Balanced.ghojeong;

public class DFS implements CheckBalanced {
  private int maxDepth;
  private int minDepth;

  private void initialize() {
    this.maxDepth = 0;
    this.minDepth = 0;
  }

  private void recursiveFunc(TreeNode node, int depth) {
    if (node.left == null && node.right == null) {
      if (minDepth == 0 && depth > 0) {
        minDepth = depth;
      } else if (minDepth > depth) {
        minDepth = depth;
      }
      if (maxDepth < depth) {
        maxDepth = depth;
      }
    }
    if (node.left != null) {
      recursiveFunc(node.left, depth + 1);
    }
    if (node.right != null) {
      recursiveFunc(node.right, depth + 1);
    }
  }

  public boolean isBalanced(TreeNode root) {
    initialize();
    recursiveFunc(root, 0);

    // HACK: side effect, 필요없는 코드
    System.out.println("maxDepth:" + maxDepth + ", minDepth:" + minDepth);

    return maxDepth - minDepth < 2;
  }
}
