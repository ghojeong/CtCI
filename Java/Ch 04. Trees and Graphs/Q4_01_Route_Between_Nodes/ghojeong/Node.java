package Q4_01_Route_Between_Nodes.ghojeong;

import java.util.Arrays;

public class Node {

  private Node adjacentArr[];
  private int MAX_ADJACENT_SIZE = 3;
  public int adjacentCount;
  private String vertex;
  public State state;

  public Node(String vertex) {
    this.vertex = vertex;
    adjacentCount = 0;
    adjacentArr = new Node[MAX_ADJACENT_SIZE];
  }

  public void addAdjacent(Node x) {
    if (adjacentCount < adjacentArr.length) {
      this.adjacentArr[adjacentCount] = x;
      adjacentCount++;
    } else {
      System.out.print("No more adjacent can be added");
    }
  }

  public Node[] getAdjacent() {
    return Arrays.copyOf(adjacentArr, adjacentCount);
  }

  public String getVertex() {
    return vertex;
  }
}
