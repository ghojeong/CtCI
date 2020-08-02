package Q8_05_Recursive_Multiply.ghojeong;

public class Tester {
	public static void main(String[] args) {
		Question[] questions = { new QuestionA("A"), new QuestionB("B"), new QuestionC("C"), new QuestionD("D"),
				new QuestionG("G") };

		for (Question q : questions) {
			System.out.println("\nQuestion" + q.label);
			q.printProduct(13494, 22323);
			q.printCounter(1000);
		}
	}
}
