package Q4_01_Route_Between_Nodes.ghojeong;

public class Node {

  private Node adjacent[];
  public int adjacentCount;
  private String vertex;
  public State state;

  public Node(String vertex, int adjacentArrLength) {
    this.vertex = vertex;
    adjacentCount = 0;
    adjacent = new Node[adjacentArrLength];
  }

  public void addAdjacent(Node x) {
    if (adjacentCount < adjacent.length) {
      this.adjacent[adjacentCount] = x;
      adjacentCount++;
    } else {
      System.out.print("No more adjacent can be added");
    }
  }

  public Node[] getAdjacent() {
    return adjacent;
  }

  public String getVertex() {
    return vertex;
  }
}
