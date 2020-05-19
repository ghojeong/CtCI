package Q5_07_Pairwise_Swap.ghojeong;

public class Question {

	private static String toFullBinaryString(int a) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			b = b.insert(0, a & 1);
			a = a >> 1;
		}
		return b.toString();
	}

	public static int swapOddEvenBits(int x) {
		int ret = 0;
		int odd = 1;
		int even = 2;
		for (int i = 0; i < 16; i++) {
			ret |= (odd & x) << 1;
			ret |= (even & x) >> 1;
			// ret |= ((odd & x) << 1) | ((even & x) >> 1);
			odd <<= 2;
			even <<= 2;
		}
		return ret;

		// 0101 = 1 + 4 = 5, 1010 = 2 + 8 = 10 = a
		// return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + toFullBinaryString(b));
	}

}
