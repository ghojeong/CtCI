package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Graph {
  private Node nodes[];
  private int MAX_NODES = 6;
  public int count;

  public Graph() {
    nodes = new Node[MAX_NODES];
    count = 0;
  }

  public void addNode(Node x) {
    if (count < nodes.length) {
      nodes[count] = x;
      count++;
    } else {
      System.out.print("Graph full");
    }
  }

  public Node[] getNodes() {
    return nodes;
  }

  public boolean search(Node start, Node end) {
    Graph graph = this;
    LinkedList<Node> ll = new LinkedList<Node>();
    for (Node node : graph.getNodes()) {
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
