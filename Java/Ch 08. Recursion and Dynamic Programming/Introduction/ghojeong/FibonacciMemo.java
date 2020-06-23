public class FibonacciMemo {
	public static int fibonacci(int n) {
		return fibonacci(n, new int[n + 1]);
	}

	public static int fibonacci(int i, int[] memo) {
		if (i == 0) {
			return 0;
		} else if (i == 1) {
			return 1;
		}

		if (memo[i] == 0) {
			memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
		}
		return memo[i];
	}
}
