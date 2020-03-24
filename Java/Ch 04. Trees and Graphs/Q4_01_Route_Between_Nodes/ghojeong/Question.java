package Q4_01_Route_Between_Nodes.ghojeong;

public class Question {

  public static void main(String a[]) {

    Node[] nodeArr = new Node[6];

    nodeArr[0] = new Node("0");
    nodeArr[1] = new Node("1");
    nodeArr[2] = new Node("2");
    nodeArr[3] = new Node("3");
    nodeArr[4] = new Node("4");
    nodeArr[5] = new Node("5");

    nodeArr[0].adjacentList.add(nodeArr[1]);
    nodeArr[0].adjacentList.add(nodeArr[2]);
    nodeArr[0].adjacentList.add(nodeArr[3]);
    nodeArr[3].adjacentList.add(nodeArr[4]);
    nodeArr[4].adjacentList.add(nodeArr[5]);

    System.out.println();
    BfsGraph bfsGraph = new BfsGraph(nodeArr);
    System.out.println("BfsRoute 0->5: " + bfsGraph.getRoute(nodeArr[0], nodeArr[5]));
    System.out.println("BfsRoute 2->5: " + bfsGraph.getRoute(nodeArr[2], nodeArr[5]));

    // System.out.println();
    // DfsGraph dfsGraph = new DfsGraph(nodeArr);
    // System.out.println("DfsRoute 0->5: " + dfsGraph.getRoute(nodeArr[0],
    // nodeArr[5]));
    // System.out.println("DfsRoute 2->5: " + dfsGraph.getRoute(nodeArr[2],
    // nodeArr[5]));
  }
}
