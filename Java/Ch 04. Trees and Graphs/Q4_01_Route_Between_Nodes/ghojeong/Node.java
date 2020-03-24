package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.LinkedList;

public class Node {
  public LinkedList<Node> adjacentList;
  public String value;
  public State state;

  public Node(String value) {
    this.value = value;
    adjacentList = new LinkedList<Node>();
  }
}
