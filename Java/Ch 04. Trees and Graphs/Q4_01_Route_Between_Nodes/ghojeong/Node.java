package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Node {
  public String value;
  public boolean isVisited;
  public LinkedList<Node> adjacentList;
  public Node calledBy;

  public Node(String value) {
    this.value = value;
    this.isVisited = false;
    adjacentList = new LinkedList<Node>();
  }

  public LinkedList<Node> getRoute() {
    LinkedList<Node> route = new LinkedList<Node>();
    Node itrNode = this;
    while (itrNode != null) {
      route.addFirst(itrNode);
      itrNode = itrNode.calledBy;
    }
    return route;
  }

  public String toString() {
    return value;
  }
}
