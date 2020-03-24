package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class RecDfsGraph extends Graph {

  public RecDfsGraph(LinkedList<Node> vertexList) {
    super(vertexList);
  };

  public RecDfsGraph(Node[] nodeArr) {
    super(nodeArr);
  }

  private void search(Node caller, Node end) {
    if (caller == null) {
      return;
    }
    visit(caller);
    for (Node adjacent : caller.adjacentList) {
      if (adjacent.isVisited) {
        continue;
      }
      adjacent.setCaller(caller);
      if (adjacent == end) {
        return;
      }
      search(adjacent, end);
    }
  }

  public LinkedList<Node> searchRoute(Node start, Node end) {
    reset();
    search(start, end);
    return end.getRoute();
  }
}
