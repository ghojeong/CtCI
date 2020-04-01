package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;
import java.util.ArrayList;

public class Bfs2CheckBalanced implements CheckBalanced {

  private int maxDepth;
  private int minDepth;
  private LinkedList<TreeNode> visitingList;

  private void initialize() {
    this.maxDepth = 0;
    this.minDepth = 0;
    this.visitingList = new LinkedList<TreeNode>();
  }

  public ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
    initialize();

    int depth = 0;
    ArrayList<LinkedList<TreeNode>> listOfDepths = new ArrayList<LinkedList<TreeNode>>();

    visitingList.add(root);
    while (!visitingList.isEmpty()) {
      listOfDepths.add(new LinkedList<TreeNode>(visitingList));
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

    return listOfDepths;
  }

  public boolean isBalanced(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> listOfDepths = getListOfDepths(root);

    System.out.println("\nmaxDepth:" + maxDepth + ", minDepth:" + minDepth);
    for (int depth = 0; depth < listOfDepths.size(); depth++) {
      System.out.println("(depth:" + depth + ")  " + listOfDepths.get(depth));
    }

    return maxDepth - minDepth < 2;
  }
}
