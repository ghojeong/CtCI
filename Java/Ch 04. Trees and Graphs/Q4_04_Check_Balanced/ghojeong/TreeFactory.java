package Q4_04_Check_Balanced.ghojeong;

public class TreeFactory {
  // BBT: Balanced Binary Tree
  // @param size: Tree의 Node의 총 갯수
  // 2^n -1 을 입력 받으면 Complete Tree 가 된다.
  public static TreeNode getBBT(int size) {
    TreeNode[] nodeArr = new TreeNode[size];
    for (int i = 0; i < nodeArr.length; i++) {
      nodeArr[i] = new TreeNode("" + i);
    }
    for (int i = 1; i < nodeArr.length; i++) {
      TreeNode parentNode = nodeArr[(int) Math.floor((i - 1) / 2)];
      if (parentNode.left == null) {
        parentNode.left = nodeArr[i];
      } else {
        parentNode.right = nodeArr[i];
      }
    }
    return nodeArr[0];
  }

  // UBT: Unbalanced Binary Tree
  public static TreeNode getUBT(int size) {
    TreeNode[] nodeArr = new TreeNode[size];
    for (int i = 0; i < nodeArr.length; i++) {
      nodeArr[i] = new TreeNode("" + i);
    }
    for (int i = 1; i < nodeArr.length; i++) {
      TreeNode parentNode = nodeArr[(int) Math.floor((i - 1) / 2)];
      if (parentNode.left == null) {
        parentNode.left = nodeArr[i];
      } else {
        parentNode.right = nodeArr[i];
      }
    }

    TreeNode node1 = new TreeNode("This");
    TreeNode node2 = new TreeNode("is");
    TreeNode node3 = new TreeNode("unbalanced");
    nodeArr[nodeArr.length - 1].right = node1;
    node1.left = node2;
    node2.right = node3;
    return nodeArr[0];
  }
}
