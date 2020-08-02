package Q8_05_Recursive_Multiply.ghojeong;

public class QuestionB extends Question {
	public QuestionB(String label) {
		super.label = label;
	}

	public int minProduct(int smaller, int bigger, int[] memo) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} else if (memo[smaller] > 0) {
			return memo[smaller];
		}

		/*
		 * Compute half. If uneven, compute other half. If even, double it.
		 */
		int s = smaller >> 1; // Divide by 2
		int side1 = minProduct(s, bigger, memo); // Compute half
		int side2 = side1;
		if (smaller % 2 == 1) {
			counter++;
			side2 = minProduct(smaller - s, bigger, memo);
		}

		/* Sum and cache. */
		counter++;
		memo[smaller] = side1 + side2;
		return memo[smaller];
	}

	public int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;

		counter++;
		int memo[] = new int[smaller + 1];
		return minProduct(smaller, bigger, memo);
	}
}
