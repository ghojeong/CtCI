package Q4_10_Check_Subtree.ghojeong;

public class Question {

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = { 1, 2, 1, 3, 1, 1, 5 };
		int[] array2 = { 2, 3, 1 };

		TreeNode t1 = new TreeNode(array1);
		TreeNode t2 = new TreeNode(array2);

		if (t1.containsTree(t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = { 1, 2, 3 };
		TreeNode t3 = new TreeNode(array1);
		TreeNode t4 = new TreeNode(array3);

		if (t3.containsTree(t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}
	}

}
