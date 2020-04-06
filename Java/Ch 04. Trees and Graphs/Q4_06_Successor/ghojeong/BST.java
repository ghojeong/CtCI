package Q4_06_Successor.ghojeong;

public class BST {
  private int size = 0;
  public TreeNode root;

  public BST(int size) {
    this.size = size;
    this.root = createBST(1, size);
  }

  private TreeNode createBST(int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(mid);
    node.setLeft(createBST(start, mid - 1));
    node.setRight(createBST(mid + 1, end));
    return node;
  }
}
