package Q4_06_Successor.ghojeong;

public class Question {

	public static TreeNode getLeftMostChild(TreeNode node) {
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static TreeNode getInOrderSuccessor(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return getLeftMostChild(node.right);
		} else if (node.parent != null) {
			TreeNode child = node;
			TreeNode parent = node.parent;
			while (parent != null && parent.right == child) {
				child = parent;
				parent = parent.parent;
			}
			return parent;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode node = getLeftMostChild(new BST(10).root);
		while (node != null) {
			TreeNode next = getInOrderSuccessor(node);
			System.out.println(node + "->" + next);
			node = next;
		}
	}

}
