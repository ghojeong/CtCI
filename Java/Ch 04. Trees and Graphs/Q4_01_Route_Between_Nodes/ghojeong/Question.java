package Q4_01_Route_Between_Nodes.ghojeong;

public class Question {

  private static Graph createNewGraph() {
    Graph g = new Graph();
    Node[] nodeArr = new Node[6];

    nodeArr[0] = new Node("a");
    nodeArr[1] = new Node("b");
    nodeArr[2] = new Node("c");
    nodeArr[3] = new Node("d");
    nodeArr[4] = new Node("e");
    nodeArr[5] = new Node("f");

    nodeArr[0].addAdjacent(nodeArr[1]);
    nodeArr[0].addAdjacent(nodeArr[2]);
    nodeArr[0].addAdjacent(nodeArr[3]);
    nodeArr[3].addAdjacent(nodeArr[4]);
    nodeArr[4].addAdjacent(nodeArr[5]);
    for (int i = 0; i < nodeArr.length; i++) {
      g.addNode(nodeArr[i]);
    }
    return g;
  }

  public static void main(String a[]) {
    Graph g = createNewGraph();
    Node[] nodeArr = g.getNodeArr();
    Node start = nodeArr[3];
    Node end = nodeArr[5];
    System.out.println(g.search(start, end));
  }
}
