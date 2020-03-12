package Q2_02_Return_Kth_To_Last;

public class QuestionJeon {
    private static class Point{
        int x;int y;
        Point(int a,int b){
            x=a;y=b;
        }
        public String toString(){
            String s = new String();
            s+="<"+x+","+y+">";
            return s;
        }
    }
	public static void main(String[] args) {
        // int[] array = {0, 1, 2, 3, 4, 5, 6};
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);
        Point p3 = new Point(1,3);
        Point p4 = new Point(1,4);
        Point p5 = new Point(1,5);

        LinkedListJeon<Point> list = new LinkedListJeon<>();
        
        //list 에 array add 해준다
        list.addLast(p1);
        list.addLast(p2);
        list.addLast(p3);
        list.addLast(p4);
        list.addLast(p5);
        //돌면서 뒤에서 k번째 값을 찍는다.
        for(int i=1;i<=5;i++){
            LinkedListJeon<Point>.Node n = list.lastKthVal(i);
            if(n!=null){
                System.out.println(i + "th : " + n.data.toString());
            }
        }
	}
}
