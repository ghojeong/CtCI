// package Q2_05_Sum_Lists;

public class QuestionJeon {
    public static class Node{
        int num; // 한 자리수 
        Node nextNode;
        Node(int val){
            num = val;
            nextNode = null;
        }
    }
	public static Node addNode(Node n1,Node n2){
        Node resNode = new Node(0);
        int carry = 0;
        Node curNode = resNode;
        Node beforeNode = null;
        while(n1!=null && n2!=null){
            int num1 = n1.num;
            int num2 = n2.num;
            int sum = num1 + num2 + carry;
            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }
            else{
                carry = 0;
            }
            curNode.num = sum;
            curNode.nextNode = new Node(0);
            beforeNode = curNode;
            curNode = curNode.nextNode;

            n1 = n1.nextNode;
            n2 = n2.nextNode;
        }
        while(n1!=null){
            int num = n1.num;
            curNode.num = num;
            curNode.nextNode = new Node(0);
            beforeNode = curNode;
            curNode = curNode.nextNode;
            n1 = n1.nextNode;
        }
        while(n2!=null){
            int num = n2.num;
            curNode.num = num;
            curNode.nextNode = new Node(0);
            beforeNode = curNode;
            curNode = curNode.nextNode;
            n2 = n2.nextNode;
        }
        if(beforeNode!=null){
            beforeNode.nextNode = null;
        }
        return resNode;
    }
	public static void main(String[] args) {
        Node a1 = new Node(7);
        Node a2 = new Node(1);
        Node a3 = new Node(6);
        Node a4 = new Node(1);
        a1.nextNode = a2;
        a2.nextNode = a3;
        a3.nextNode = a4;

        Node b1 = new Node(5);
        Node b2 = new Node(9);
        Node b3 = new Node(2);
        b1.nextNode = b2;
        b2.nextNode = b3;
        Node c = addNode(a1,b1);
        while(c!=null){
            System.out.print(c.num + " / ");
            System.out.println();
            c = c.nextNode;
        }
	}
}
