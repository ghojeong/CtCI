package Q4_01_Route_Between_Nodes.ghojeong;

public class Question {
  public static void main(String a[]) {
    Graph graph;
    Node[] nodeArr = new Node[15]; // 15 = 2^4 -1
    for (int i = 0; i < nodeArr.length; i++) {
      nodeArr[i] = new Node("" + i);
    }
    for (int i = 1; i < nodeArr.length; i++) {
      nodeArr[(int) Math.floor((i - 1) / 2)].adjacentList.add(nodeArr[i]);
    }

    graph = new BfsGraph(nodeArr);
    printRoute(graph, nodeArr[0], nodeArr[10], "\nBfsRoute 0->10");
    printRoute(graph, nodeArr[1], nodeArr[2], "BfsRoute 1->2");

    graph = new DfsGraph(nodeArr);
    printRoute(graph, nodeArr[0], nodeArr[10], "\nDfsRoute 0->10");
    printRoute(graph, nodeArr[1], nodeArr[2], "DfsRoute 1->2");

    graph = new RecDfsGraph(nodeArr);
    printRoute(graph, nodeArr[0], nodeArr[10], "\nRecDfsRoute 0->10");
    printRoute(graph, nodeArr[1], nodeArr[2], "RecDfsRoute 1->2");
  }

  public static void printRoute(Graph graph, Node start, Node end, String tag) {
    System.out.println(tag + ": " + graph.searchRoute(start, end));
    System.out.println("Visited History: " + graph.getVisitedHistory());
  }
}
