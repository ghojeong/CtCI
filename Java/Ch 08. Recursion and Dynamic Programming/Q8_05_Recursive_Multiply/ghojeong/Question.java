package Q8_05_Recursive_Multiply.ghojeong;

public abstract class Question {
	public int counter = 0;
	public String label;

	public abstract int minProduct(int a, int b);

	public void printProduct(int a, int b) {
		int product = a * b;
		int minProduct = minProduct(a, b);
		if (product == minProduct) {
			System.out.println("Success: " + a + " * " + b + " = " + product);
		} else {
			System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
		}
		System.out.println("Adds: " + counter);
	}

	public void printCounter(int max) {
		int acc = 0;

		for (int a = 0; a < max; a++) {
			for (int b = 0; b < max; b++) {
				counter = 0;
				int prod = a * b;
				int prodQ = minProduct(a, b);
				acc += counter;

				if (prod != prodQ) {
					System.out.println(" Failure: " + a + " * " + b + " = " + prod + " instead of (" + prodQ + ")");
					break;
				}
			}
		}
		System.out.println("Acc: " + acc);
	}
}
