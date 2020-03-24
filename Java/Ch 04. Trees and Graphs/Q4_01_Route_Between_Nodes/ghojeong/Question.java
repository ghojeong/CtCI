package Q4_01_Route_Between_Nodes.ghojeong;

public class Question {

  public static void main(String a[]) {

    Node[] nodeArr = new Node[6];

    nodeArr[0] = new Node("a");
    nodeArr[1] = new Node("b");
    nodeArr[2] = new Node("c");
    nodeArr[3] = new Node("d");
    nodeArr[4] = new Node("e");
    nodeArr[5] = new Node("f");

    nodeArr[0].adjacentList.add(nodeArr[1]);
    nodeArr[0].adjacentList.add(nodeArr[2]);
    nodeArr[0].adjacentList.add(nodeArr[3]);
    nodeArr[3].adjacentList.add(nodeArr[4]);
    nodeArr[4].adjacentList.add(nodeArr[5]);

    Graph graph = new Graph(nodeArr);
    Node start = nodeArr[3];
    Node end = nodeArr[5];
    System.out.println(graph.search(start, end));
  }
}
