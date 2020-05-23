public class QuestionJeon {
    public static void drawLine(byte[] screen,int width,
    int x1,int x2,int y){
        if(x1>x2){//swap
            x1 ^= x2;
            x2 ^= x1;
            x1 ^= x2;
        }
        int left_edge = (width/8) * y;
        int start_edge =  (x1 / 8) + left_edge;
        int start_pos = (x1 % 8);
        int end_edge = (x2/8) + left_edge;
        int end_pos = (x2 % 8);
        
        int[] start_possible = {0b1,0b11,0b111,0b1111,0b11111,0b111111,0b1111111,0b11111111};
        int[] end_possible = {0b10000000,0b11000000,0b11100000,0b11110000,0b11111000,0b11111100,0b11111110,0b11111111};
        if(start_edge == end_edge){
            screen[start_edge] = (byte)(start_possible[7-start_pos] & end_possible[end_pos]);
            return;
        }
        for(int i=start_edge+1; i<=end_edge-1;i++){
            screen[i] = (byte)0xFF;
        }
        screen[start_edge] = (byte)start_possible[7-start_pos];
        screen[end_edge] = (byte)end_possible[end_pos];
    }
    public static void main(String[] args){
        int w = 80;
        int h = 10;
        byte[] screen = new byte[ (w/8) * h];
        drawLine(screen, w, 20, 9, 2);
        for(int i=0;i<3;i++){
            for(int j=0;j<(w / 8);j++){
                int temp = screen[i*(w/8)+j];
                for(int k=0;k<8;k++){
                    if((temp & 0b10000000)>0){
                        System.out.print("1");
                    }
                    else{
                        System.out.print("0");
                    }
                    temp <<=1;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}