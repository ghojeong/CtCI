package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Node {
  public String value;
  public State state;
  public LinkedList<Node> adjacentList;
  public Node calledBy;

  public Node(String value) {
    this.value = value;
    this.state = State.Unvisited;
    adjacentList = new LinkedList<Node>();
  }

  public String toString() {
    return value;
  }
}
