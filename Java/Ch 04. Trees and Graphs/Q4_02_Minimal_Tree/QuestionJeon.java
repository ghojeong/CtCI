package Q4_02_Minimal_Tree;
class QuestionJeon{
    static int max_depth=0;
    public static Node recursiveMakeBBT(int []arr,int left,int right,int d){
        if(left>right)return null;
        if(d>max_depth)max_depth = d;
        int mid  = (left+right)/2;
        Node cur = new Node(arr[mid],d);
        cur.left = recursiveMakeBBT(arr, left, mid-1,d+1);
        cur.right = recursiveMakeBBT(arr, mid+1, right,d+1);
        return cur;
    }
    public static Node makeBBT(int[] arr){
        //재귀적으로 left,right를 넘겨서 이진트리를 만들어준다
        return recursiveMakeBBT(arr,0,arr.length-1,1);
    }
    public static void inOrder(Node n){
        if(n.left!=null)inOrder(n.left);
        System.out.print(n.node+" ");
        if(n.right!=null)inOrder(n.right);
    }
    public static void preOrder(Node n){
        System.out.print(n.node+" ");
        if(n.left!=null)preOrder(n.left);
        if(n.right!=null)preOrder(n.right);
    }
    public static void postOrder(Node n){
        if(n.left!=null)postOrder(n.left);
        if(n.right!=null)postOrder(n.right);
        System.out.print(n.node+" ");
    }
    public static void main(String args[]){
        int[] arr = new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        //균형 이진트리를 만들어 준다 
        // Node root = makeBBT(arr);

        preOrder(root);System.out.println("");
        inOrder(root);System.out.println("");
        postOrder(root);System.out.println("");
        System.out.println("depth : " +(max_depth));
    }
}