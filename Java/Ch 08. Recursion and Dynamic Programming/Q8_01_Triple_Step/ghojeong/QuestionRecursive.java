package Q8_01_Triple_Step.ghojeong;

// spatial BigO = O(3^n)
// temporal BigO = O(3^n)

public class QuestionRecursive {

	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

}
