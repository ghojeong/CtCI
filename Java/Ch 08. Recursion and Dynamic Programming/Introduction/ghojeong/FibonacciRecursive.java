
// spatial & temporal BigO = O(2^n)
public class FibonacciRecursive {
	public int fibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}
