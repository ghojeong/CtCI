public class MyStack implements StackInterface{
    Stack stack;
    Stack mstack;//when min refreshed -> push val
    
    MyStack(){
        stack = new Stack();
        mstack = new Stack();
    }
    private class Stack implements StackInterface{
        int[] arr;
        int top;
        Stack(){
            arr = new int[100];
            top = 0;
        }
        public void push(int val){
            arr[top++] = val;
        }
        public int peek(){
            if(top>0)return arr[top-1];
            else{
                return -1;
            }
        }
        public void pop(){
            if(top>0)top--;
        }
        public boolean isEmpty(){
            return top==0;
        }
        public String toString(){
            String ret = "[";
            for(int i=top-1;i>=0;i--){
                 ret+=arr[i]+ ", ";
            }
            ret+="]";
            return ret;
        }
    }
    public void push(int val){
        if(stack.isEmpty()||mstack.peek()>=val){
            mstack.push(val);
        }    
        stack.push(val);
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void pop(){
        if(mstack.peek()==stack.peek()){
            mstack.pop();
        }
        stack.pop();
    }
    public int min(){
        return mstack.peek();
    }
    public int peek(){
        return stack.peek();
    }
    public String toString(){
        return ""+stack;
    }
}