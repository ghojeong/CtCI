package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class BfsGraph {
  public LinkedList<Node> vertexList;

  public BfsGraph(LinkedList<Node> vertexList) {
    this.vertexList = vertexList;
  };

  public BfsGraph(Node[] nodeArr) {
    this.vertexList = new LinkedList<Node>();
    for (int i = 0; i < nodeArr.length; i++) {
      this.vertexList.add(nodeArr[i]);
    }
  }

  public LinkedList<Node> getRoute(Node start, Node end) {
    for (Node vertex : vertexList) {
      vertex.isVisited = false;
      vertex.calledBy = null;
    }
    LinkedList<Node> visitingList = new LinkedList<Node>();
    visitingList.add(start);
    start.isVisited = true;
    Node node;
    while (!visitingList.isEmpty()) {
      node = visitingList.removeFirst();
      if (node == null) {
        continue;
      }
      for (Node adjacent : node.adjacentList) {
        if (adjacent.isVisited) {
          continue;
        }
        adjacent.calledBy = node;
        if (adjacent == end) {
          return end.getRoute();
        }
        visitingList.add(adjacent);
        adjacent.isVisited = true;
      }
    }
    return null;
  }
}
