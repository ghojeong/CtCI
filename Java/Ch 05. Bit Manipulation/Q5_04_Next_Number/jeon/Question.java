public class Question{
	public static int getNext(int n) {
        int count_0=0;
        int count_1=0;
        int temp = n;
        while(((0x1 & temp)==0) && (temp != 0)){
            count_0++;
            temp>>=1;
        }
        if(count_1==31 || temp == 0){//all 0
            return -1;
        }
        while(((0x1 & temp)==1) && (temp != 0)){
            count_1++;
            temp>>=1;
        }
        if(count_1 +count_0 ==31 || temp==0){//111...000
            return -1;
        }
        int pos = count_1 + count_0;
        int mask = 0x1 <<pos;
        n|=mask;
        //pos 오른쪽 밀기
        mask-=1;
        mask = ~mask;
        n &=mask;
        //pos 아래 최하단 count_1 -1 만큼 1로 채우기
        mask = (0x1<<(count_1-1))-1;
        n|=mask;
		return n;
	}

	public static int getPrev(int n) {	
        int count_0=0;
        int temp = n;
        while(((0x1 & temp)==1) && (temp != 0)){
            count_0++;
            temp>>=1;
        }
        if(count_0==0 || temp == 0){//000....1111 || 000..000
            return -1;
        }
        int pos = count_0;
        int mask = 0x1 <<pos;
        //pos번째 1 0으로 바꾸기
        mask = ~mask;
        n &= mask;
        //pos번째 아래비트 (pos)10000..000 형태로 바꾸기
        n |= (0x1<<(pos-1));
		return n;
    }	
	public static void main(String[] args) {
		int i = 13948;
        System.out.println(getNext(i));
        System.out.println(getPrev(i));
	}
}
