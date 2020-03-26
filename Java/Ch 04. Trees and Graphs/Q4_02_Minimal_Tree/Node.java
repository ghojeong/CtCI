package Q4_02_Minimal_Tree;
public class Node{
    int node;
    Node left;
    Node right;
    int depth;
    Node(int val,int d){
        node= val;
        left = null;
        right=null;
        depth = d;
    }
}