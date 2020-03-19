public class Main {
    //implement stack thak knows min() ->O(1) 
    public static void main(String[] args) {
        MyStack s = new MyStack();
        for(int i=0;i<10;i++){
            int val = (int)(Math.random()*10);
            s.push(val);
        }
        System.out.println(s);
        while(!s.isEmpty()){
            System.out.println(s);
            System.out.println(s.peek() + ", " +s.min() );
            s.pop();
        }
    }
    
}
