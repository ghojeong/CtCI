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
			return;
		}
		sb.append(node.data);
		buildOrderStr(node.left, sb);
		buildOrderStr(node.right, sb);
	}

	public boolean containsTree(TreeNode node) {
		StringBuilder thisBuilder = new StringBuilder();
		StringBuilder nodeBuilder = new StringBuilder();

		buildOrderStr(this, thisBuilder);
		buildOrderStr(node, nodeBuilder);

		return thisBuilder.toString().contains(nodeBuilder.toString());
	}
}
