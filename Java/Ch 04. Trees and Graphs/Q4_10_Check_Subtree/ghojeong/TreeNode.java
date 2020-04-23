package Q4_10_Check_Subtree.ghojeong;

import java.util.LinkedList;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode(int[] array) {
		if (array.length < 1) {
			return;
		}
		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		this.data = array[0];
		ll.add(this);
		for (int i = 1; i < array.length; i++) {
			TreeNode r = ll.getFirst();
			if (r.left == null) {
				r.left = new TreeNode(array[i]);
				ll.addLast(r.left);
			} else if (r.right == null) {
				r.right = new TreeNode(array[i]);
				ll.addLast(r.right);
			} else {
				ll.removeFirst();
			}
		}
	}

	private void buildOrderStr(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");
			return;
		}
		sb.append(node.data);
		buildOrderStr(node.left, sb);
		buildOrderStr(node.right, sb);
	}

	public boolean containsTree(TreeNode node) {
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		buildOrderStr(this, str1);
		buildOrderStr(node, str2);

		return str1.indexOf(str2.toString()) != -1;
	}
}
