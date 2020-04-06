package Q4_06_Successor.ghojeong;

public class TreeNode {
  public int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;

  public TreeNode(int data) {
    this.data = data;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  public void setRight(TreeNode right) {
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  public String toString() {
    return "" + data;
  }
}
