import java.util.LinkedList;
import java.util.Queue;
public class QuestionJeon {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int n){
            left = null;
            right = null;
            val = n;
        }
    }
    public static Node genTree(){
        int[] arr = {10,5,14,5,6,12,15};
        int size = arr.length;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for(int i=0;i<size;i++){
            Node cur = q.poll();
            if((i*2+1)<size){
                if(arr[i*2+1]!=0)cur.left = new Node(arr[i*2+1]);
                q.add(cur.left);
            }
            if((i*2+2) <size){
                if(arr[i*2+2]!=0)cur.right = new Node(arr[i*2+2]);
                q.add(cur.right);
            }
        }
        return root;
    }
    public static boolean recursiveCheckBST(Node n,Integer min,Integer max){
        //모든 값이 max보다 작거나 같아야 된다
        //모든 값이 min보다 커야함
        if((max==null || max>=n.val) &&(min==null || min<n.val)){//조건 만족
            boolean leftCheck=false,rightCheck=false;
            if(n.left==null ||recursiveCheckBST(n.left, min, n.val)){
                leftCheck=true;
            }
            else return false;
            
            if(n.right==null ||recursiveCheckBST(n.right, n.val, max)){
                rightCheck=true;
            } 
            else return false;
            return leftCheck && rightCheck;
        }
        return false;
    }
    public static boolean isBST(Node root){
        return recursiveCheckBST(root, null, null);
    } 
    public static void inOrder(Node r){
        if(r.left!=null)inOrder(r.left);
        System.out.println(r.val);
        if(r.right!=null)inOrder(r.right);
    }
    public static void main(String[] args) {
        //Def of BST : all sub left <= val && all sub right > val
        Node root = genTree();
        inOrder(root);
        System.out.println();
        System.out.println(isBST(root));
    }
}