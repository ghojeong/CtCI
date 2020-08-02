package Q8_05_Recursive_Multiply.ghojeong;

public class QuestionC extends Question {
	public QuestionC(String label) {
		super.label = label;
	}

	private int minProductHelper(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}

		int s = smaller >> 1;
		int halfProd = minProductHelper(s, bigger);

		if (smaller % 2 == 0) {
			counter++;
			return halfProd + halfProd;
		} else {
			counter += 2;
			return halfProd + halfProd + bigger;
		}
	}

	public int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return minProductHelper(smaller, bigger);
	}
}
