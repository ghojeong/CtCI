package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class DfsGraph extends Graph {

  public DfsGraph(LinkedList<Node> vertexList) {
    super(vertexList);
  };

  public DfsGraph(Node[] nodeArr) {
    super(nodeArr);
  }

  public LinkedList<Node> searchRoute(Node start, Node end) {
    reset();
    visit(start);
    while (!visitingList.isEmpty()) {
      Node caller = visitingList.removeFirst();
      if (caller == null) {
        continue;
      }
      for (Node adjacent : caller.adjacentList) {
        if (adjacent.isVisited) {
          continue;
        }
        adjacent.caller = caller;
        if (adjacent == end) {
          return end.getRoute();
        }
        visit(adjacent);
      }
    }
    return null;
  }
}
