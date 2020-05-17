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
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + toFullBinaryString(b));
	}

}
