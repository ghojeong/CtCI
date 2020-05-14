

import java.util.ArrayList;

public class QuestionJeon {
    static ArrayList<Node> arrNode;
    public static class Node{
        int val;
        Node leftChild;
        Node rightChild;
        int leftSize;
        int rightSize;
        Node(int num){
            leftChild = null;
            rightChild = null;
            leftSize = 0;
            rightSize = 0;
            val = num;
        }
        public void insertNode(Node n){
            if(n.val > this.val){
                this.rightSize++;
                if(this.rightChild == null){
                    this.rightChild = n;
                    return;
                }
                this.rightChild.insertNode(n);
            }
            else if(n.val<this.val){
                this.leftSize++;
                if(this.leftChild == null){
                    this.leftChild = n;
                    return;
                }
                this.leftChild.insertNode(n);
            }
            else{
                System.out.println("same val");
            }
        }

    }
    
    public static Node getRandomNode(Node current){
        int totalSize = current.leftSize + current.rightSize + 1;
        int randNum = (int)(Math.random() * totalSize);
        if(randNum == 0){
            return current;
        }
        else if(randNum <= current.leftSize){
            return getRandomNode(current.leftChild);
        }
        else{
            return getRandomNode(current.rightChild);
        }
    }
	public static void main(String[] args) {
        Node root = new Node(50);
        for(int i=0;i<10;i++){
            int val = (int)(Math.random()*100);
            Node n = new Node(val);
            root.insertNode(n);
        }
        for(int i=0;i<100;i++){
            Node cur = getRandomNode(root);
            System.out.println(cur.val);
        }
    }
}
