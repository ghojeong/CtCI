import java.util.*;

class Solution {
  public int MAX_EDGES = 400;
  public int[] shortestPathLen;
  public HashSet<Edge> visitingSet;
  public Edge[] redEdges;
  public Edge[] blueEdges;

  public class Edge {
    public int idx;
    public LinkedList<Edge> toList;
    public Edge(int idx) {
      this.idx = idx;
      this.toList = new LinkedList<Edge>();
    }
  }

  public void initialize(int n, int[][] red_edges, int[][] blue_edges) {
    shortestPathLen = new int[n];
    redEdges = new Edge[MAX_EDGES];
    blueEdges = new Edge[MAX_EDGES];
    for(int i=0; i<n; i++) {
      shortestPathLen[i] = -1;
    }
    for(int i=0; i<MAX_EDGES; i++) {
      redEdges[i] = new Edge(i);
      blueEdges[i] = new Edge(i);
    }
  }

  public void connectEdges(int n, int[][] red_edges, int[][] blue_edges) {
    for(int i=0; i<red_edges.length; i++) {
      int fromIdx = red_edges[i][0];
      int toIdx = red_edges[i][1];
      redEdges[fromIdx].toList.add(blueEdges[toIdx]);
    }
    for(int i=0; i<blue_edges.length; i++) {
      int fromIdx = blue_edges[i][0];
      int toIdx = blue_edges[i][1];
      blueEdges[fromIdx].toList.add(redEdges[toIdx]);
    }
  }

  public void calcShortestPathLen(Edge edge, int pathLen) {
    int spl = shortestPathLen[edge.idx];
    if (spl<0 || spl>pathLen) {
      shortestPathLen[edge.idx] = pathLen;
    }
    if (!visitingSet.add(edge)) {
      return;
    }
    for(Edge toEdge: edge.toList) {
      calcShortestPathLen(toEdge, pathLen+1);
    }
  }

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    initialize(n, red_edges, blue_edges);
    connectEdges(n, red_edges, blue_edges);
    visitingSet = new HashSet<Edge>();
    calcShortestPathLen(redEdges[0], 0);
    visitingSet = new HashSet<Edge>();
    calcShortestPathLen(blueEdges[0], 0);
    return shortestPathLen;
  }

  public static void main(String[] args) {
    int[][] red_edges = {{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
    int[][] blue_edges = {{1,3},{0,0},{0,3},{4,2},{1,0}};
    System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(5, red_edges, blue_edges)));
    // [0,1,2,1,1]
  }
}
