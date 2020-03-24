package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public abstract class Graph {
  protected LinkedList<Node> vertexList;
  protected LinkedList<Node> visitingList;
  private LinkedList<Node> visitedList;

  protected Graph(LinkedList<Node> vertexList) {
    this.vertexList = vertexList;
    this.visitingList = new LinkedList<Node>();
  };

  protected Graph(Node[] nodeArr) {
    this.vertexList = new LinkedList<Node>();
    this.visitingList = new LinkedList<Node>();
    for (int i = 0; i < nodeArr.length; i++) {
      this.vertexList.add(nodeArr[i]);
    }
  }

  protected void visit(Node node) {
    visitingList.add(node);
    visitedList.add(node);
    node.isVisited = true;
  }

  protected void reset() {
    visitingList = new LinkedList<Node>();
    visitedList = new LinkedList<Node>();
    for (Node vertex : vertexList) {
      vertex.isVisited = false;
      vertex.setCaller(null);
    }
  }

  public LinkedList<Node> getVisitedHistory() {
    return visitedList;
  };

  public abstract LinkedList<Node> searchRoute(Node start, Node end);
}
