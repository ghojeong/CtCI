package Q8_01_Triple_Step.ghojeong;

public class Tester {

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			int c1 = QuestionRecursive.countWays(i);
			int c2 = QuestionMemo.countWays(i);
			int c3 = QuestionIterative.countWays(i);
			int c4 = QuestionOptimized.countWays(i);
			System.out.println(i + ": " + c1 + " " + c2 + " " + c3 + " " + c4);
		}
	}

}
