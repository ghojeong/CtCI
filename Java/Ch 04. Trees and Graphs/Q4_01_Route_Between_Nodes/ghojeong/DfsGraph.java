package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class DfsGraph extends Graph {

  public DfsGraph(LinkedList<Node> vertexList) {
    super(vertexList);
  };

  public DfsGraph(Node[] nodeArr) {
    super(nodeArr);
  }

  private void search(Node start, Node end) {
    if (start == null) {
      return;
    }
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
        search(adjacent, end);
      }
    }
  }

  public LinkedList<Node> searchRoute(Node start, Node end) {
    reset();
    search(start, end);
    return end.getRoute();
  }
}
