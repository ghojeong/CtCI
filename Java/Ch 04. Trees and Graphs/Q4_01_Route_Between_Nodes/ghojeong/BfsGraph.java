package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class BfsGraph extends Graph {

  public BfsGraph(LinkedList<Node> vertexList) {
    super(vertexList);
  };

  public BfsGraph(Node[] nodeArr) {
    super(nodeArr);
  }

  private void search(Node start, Node end) {
    visit(start);
    while (!visitingList.isEmpty()) {
      Node caller = visitingList.removeFirst();
      for (Node adjacent : caller.adjacentList) {
        if (adjacent.isVisited) {
          continue;
        }
        adjacent.caller = caller;
        if (adjacent == end) {
          return;
        }
        visit(adjacent);
      }
    }
  }

  public LinkedList<Node> searchRoute(Node start, Node end) {
    reset();
    search(start, end);
    return end.getRoute();
  }
}
