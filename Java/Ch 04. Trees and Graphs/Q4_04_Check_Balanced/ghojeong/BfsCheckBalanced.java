package Q4_04_Check_Balanced.ghojeong;

import java.util.LinkedList;
import java.util.ArrayList;

public class BfsCheckBalanced implements CheckBalanced {

  private int maxDepth;
  private int minDepth;
  private LinkedList<TreeNode> visitingList;
  private LinkedList<TreeNode> childList;

  private void initialize() {
    this.maxDepth = 0;
    this.minDepth = 0;
    this.visitingList = new LinkedList<TreeNode>();
    this.childList = new LinkedList<TreeNode>();
  }

  public ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
    initialize();

    ArrayList<LinkedList<TreeNode>> listOfDepths = new ArrayList<LinkedList<TreeNode>>();

    visitingList.add(root);
    listOfDepths.add(new LinkedList<TreeNode>(visitingList));
    while (!visitingList.isEmpty() || !childList.isEmpty()) {
      if (visitingList.isEmpty()) {
        visitingList = childList;
        childList = new LinkedList<TreeNode>();
        maxDepth++;
        listOfDepths.add(new LinkedList<TreeNode>(visitingList));
      }
      TreeNode node = visitingList.remove();
      if (node.left == null && node.right == null && minDepth == 0) {
        minDepth = maxDepth;
      }
      if (node.left != null) {
        childList.add(node.left);
      }
      if (node.right != null) {
        childList.add(node.right);
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
