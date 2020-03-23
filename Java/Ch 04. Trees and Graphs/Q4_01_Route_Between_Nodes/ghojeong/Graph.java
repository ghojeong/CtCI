package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Graph {
  private Node nodeArr[];
  private int MAX_NODE_SIZE = 6;
  public int count;

  public Graph() {
    nodeArr = new Node[MAX_NODE_SIZE];
    count = 0;
  }

  public void addNode(Node x) {
    if (count < nodeArr.length) {
      nodeArr[count] = x;
      count++;
    } else {
      System.out.print("Graph full");
    }
  }

  public Node[] getNodeArr() {
    return nodeArr;
  }

  public boolean search(Node start, Node end) {
    LinkedList<Node> ll = new LinkedList<Node>();
    for (Node node : nodeArr) {
      node.state = State.Unvisited;
    }
    start.state = State.Visiting;
    ll.add(start);
    Node node;
    while (!ll.isEmpty()) {
      node = ll.removeFirst();
      if (node == null) {
        continue;
      }
      for (Node adjacent : node.getAdjacent()) {
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
