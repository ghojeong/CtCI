package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class BfsGraph {
  public LinkedList<Node> vertexList;
  private LinkedList<Node> visitingList;

  public BfsGraph(LinkedList<Node> vertexList) {
    this.vertexList = vertexList;
    this.visitingList = new LinkedList<Node>();
  };

  public BfsGraph(Node[] nodeArr) {
    this.vertexList = new LinkedList<Node>();
    this.visitingList = new LinkedList<Node>();
    for (int i = 0; i < nodeArr.length; i++) {
      this.vertexList.add(nodeArr[i]);
    }
  }

  private void visit(Node node) {
    visitingList.add(node);
    node.isVisited = true;
  }

  private void reset() {
    visitingList = new LinkedList<Node>();
    for (Node vertex : vertexList) {
      vertex.isVisited = false;
      vertex.calledBy = null;
    }
  }

  public LinkedList<Node> searchRoute(Node start, Node end) {
    reset();
    visit(start);
    while (!visitingList.isEmpty()) {
      Node node = visitingList.removeFirst();
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
        visit(adjacent);
      }
    }
    return null;
  }
}
