package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Graph {
  public LinkedList<Node> vertexList;

  public Graph(LinkedList<Node> vertexList) {
    this.vertexList = vertexList;
  };

  public Graph(Node[] nodeArr) {
    this.vertexList = new LinkedList<Node>();
    for (int i = 0; i < nodeArr.length; i++) {
      this.vertexList.add(nodeArr[i]);
    }
  }

  public boolean search(Node start, Node end) {
    LinkedList<Node> ll = new LinkedList<Node>();
    for (Node vertex : vertexList) {
      vertex.state = State.Unvisited;
    }
    start.state = State.Visiting;
    ll.add(start);
    Node node;
    while (!ll.isEmpty()) {
      node = ll.removeFirst();
      if (node == null) {
        continue;
      }
      for (Node adjacent : node.adjacentList) {
        if (adjacent.state != State.Unvisited) {
          continue;
        }
        if (adjacent == end) {
          return true;
        }
        adjacent.state = State.Visiting;
        ll.add(adjacent);
      }
      node.state = State.Visited;
    }
    return false;
  }
}
