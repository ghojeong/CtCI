package Q8_05_Recursive_Multiply.ghojeong;

public class QuestionD extends Question {
	public QuestionD(String label) {
		super.label = label;
	}

	public int minProduct(int a, int b) {
		if (a < b)
			return minProduct(b, a);
		int value = 0;
		while (a > 0) {
			counter++;
			if ((a % 10) % 2 == 1) {
				value += b;
			}
			a >>= 1;
			b <<= 1;
		}
		return value;
	}
}
