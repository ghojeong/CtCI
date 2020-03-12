package Q2_02_Return_Kth_To_Last;

public class LinkedListJeon<T>{
    Node head;//첫번째 노드
    Node last;//마지막 노드
    static int size;
    public class Node{
        T data;
        Node next;
        Node(T x){
            data = x;
            next = null;
        }
    }
    LinkedListJeon(){
        head = last = null;
        size = 0;
    }
    public void addLast(T val){
        Node n = new Node(val);
        if(size==0){
            head = last =n;
            size++;
        }
        else{
            last.next = n;
            size++;
            last = n;
        }
    }
    public Node lastKthVal(int k){
        if(k>size){
            System.out.println("Cannot delete");
            return null;
        }
        int cnt = 0;
        Node n = head;
        while(true){
            if(size - k ==cnt){
                return n; 
            }
            cnt++;
            n=n.next;
        }
    }
}