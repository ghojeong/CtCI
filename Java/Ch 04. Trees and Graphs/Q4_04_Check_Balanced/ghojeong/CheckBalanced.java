package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;

public class CheckBalanced {

  private int depth;
  private int minDepth;
  private LinkedList<TreeNode> visitingList;
  private LinkedList<TreeNode> childList;

  private void initialize() {
    this.depth = 0;
    this.minDepth = 0;
    this.visitingList = new LinkedList<TreeNode>();
    this.childList = new LinkedList<TreeNode>();
  }

  public boolean isBalanced(TreeNode root) {
    initialize();

    visitingList.add(root);
    System.out.println("(depth:0)  " + visitingList); // HACK: side effect, 필요없는 코드
    while (!visitingList.isEmpty() || !childList.isEmpty()) {
      if (visitingList.isEmpty()) {
        visitingList = childList;
        childList = new LinkedList<TreeNode>();
        depth++;
        System.out.println("(depth:" + depth + ")  " + visitingList); // HACK: side effect, 필요없는 코드
      }
      TreeNode node = visitingList.remove();
      if (node.left == null && node.right == null && minDepth == 0) {
        minDepth = depth;
      }
      if (node.left != null) {
        childList.add(node.left);
      }
      if (node.right != null) {
        childList.add(node.right);
      }
    }

    return depth - minDepth < 2;
  }
}
