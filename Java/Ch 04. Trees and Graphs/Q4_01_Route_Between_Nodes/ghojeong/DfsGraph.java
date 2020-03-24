package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class DfsGraph {
  public LinkedList<Node> vertexList;

  public DfsGraph(LinkedList<Node> vertexList) {
    this.vertexList = vertexList;
  };

  public DfsGraph(Node[] nodeArr) {
    this.vertexList = new LinkedList<Node>();
    for (int i = 0; i < nodeArr.length; i++) {
      this.vertexList.add(nodeArr[i]);
    }
  }

  public LinkedList<Node> getRoute(Node start, Node end) {
    LinkedList<Node> visitingList = new LinkedList<Node>();
    start.state = State.Visiting;
    visitingList.add(start);
    Node node;
    while (!visitingList.isEmpty()) {
      node = visitingList.removeFirst();
      node.state = State.Visited;
      if (node == null) {
        continue;
      }
      for (Node adjacent : node.adjacentList) {
        if (adjacent.state != State.Unvisited) {
          continue;
        }
        adjacent.calledBy = node;
        if (adjacent == end) {
          LinkedList<Node> route = new LinkedList<Node>();
          Node itrNode = end;
          while (itrNode != null) {
            route.addFirst(itrNode);
            itrNode = itrNode.calledBy;
          }
          return route;
        }
        adjacent.state = State.Visiting;
        visitingList.add(adjacent);
      }
    }
    return null;
  }
}
