package Q4_01_Route_Between_Nodes.ghojeong;

public class Question {

  private static Graph createNewGraph() {
    Graph g = new Graph();
    Node[] nodes = new Node[6];

    nodes[0] = new Node("a", 3);
    nodes[1] = new Node("b", 0);
    nodes[2] = new Node("c", 0);
    nodes[3] = new Node("d", 1);
    nodes[4] = new Node("e", 1);
    nodes[5] = new Node("f", 0);

    nodes[0].addAdjacent(nodes[1]);
    nodes[0].addAdjacent(nodes[2]);
    nodes[0].addAdjacent(nodes[3]);
    nodes[3].addAdjacent(nodes[4]);
    nodes[4].addAdjacent(nodes[5]);
    for (int i = 0; i < nodes.length; i++) {
      g.addNode(nodes[i]);
    }
    return g;
  }

  public static void main(String a[]) {
    Graph g = createNewGraph();
    Node[] nodes = g.getNodes();
    Node start = nodes[3];
    Node end = nodes[5];
    System.out.println(g.search(start, end));
  }
}
