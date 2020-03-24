import java.util.LinkedList;

public class TreeTraversal {
  public static void main(String a[]) {
    new BfsTree(treeFactory()).traversal();
    System.out.println();
    new DfsTree(treeFactory()).traversal();
  }

  public static class Node {
    public String value;
    public boolean isVisited;
    public LinkedList<Node> childList;

    public Node(String value) {
      this.value = value;
      this.isVisited = false;
      childList = new LinkedList<Node>();
    }
  }

  public static class BfsTree {
    private Node root;
    private LinkedList<Node> visitingList;

    public BfsTree(Node root) {
      this.root = root;
      this.visitingList = new LinkedList<Node>();
    };

    private void visit(Node node) {
      node.isVisited = true;
      visitingList.add(node);
      System.out.print(node.value + " ");
    }

    public void traversal() {
      visit(root);
      while (!visitingList.isEmpty()) {
        Node node = visitingList.removeFirst();
        for (Node child : node.childList) {
          if (!child.isVisited) {
            visit(child);
          }
        }
      }
    }
  }

  public static class DfsTree {
    private Node root;

    public DfsTree(Node root) {
      this.root = root;
    };

    private void recursiveFunc(Node node) {
      if (node == null) {
        return;
      }
      node.isVisited = true;
      for (Node child : node.childList) {
        if (!child.isVisited) {
          recursiveFunc(child);
        }
      }
      System.out.print(node.value + " ");
    }

    public void traversal() {
      recursiveFunc(root);
    }
  }

  public static Node treeFactory() {
    Node[] nodeArr = new Node[8];

    nodeArr[0] = new Node("0");
    nodeArr[1] = new Node("1");
    nodeArr[2] = new Node("2");
    nodeArr[3] = new Node("3");
    nodeArr[4] = new Node("4");
    nodeArr[5] = new Node("5");
    nodeArr[6] = new Node("6");
    nodeArr[7] = new Node("7");

    nodeArr[0].childList.add(nodeArr[1]);
    nodeArr[0].childList.add(nodeArr[2]);

    nodeArr[1].childList.add(nodeArr[3]);
    nodeArr[1].childList.add(nodeArr[4]);

    nodeArr[3].childList.add(nodeArr[5]);
    nodeArr[3].childList.add(nodeArr[6]);

    nodeArr[4].childList.add(nodeArr[7]);

    Node root = nodeArr[0];
    return root;
  }
}
