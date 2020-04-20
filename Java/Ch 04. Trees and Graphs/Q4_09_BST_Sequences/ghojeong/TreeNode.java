package Q4_09_BST_Sequences.ghojeong;

public class TreeNode {
  public int data;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int d) {
    data = d;
  }

  public void insertInOrder(int d) {
    if (d <= data) {
      if (left == null) {
        left = new TreeNode(d);
      } else {
        left.insertInOrder(d);
      }
    } else {
      if (right == null) {
        right = new TreeNode(d);
      } else {
        right.insertInOrder(d);
      }
    }
  }
}
