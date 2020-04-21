package Q4_09_BST_Sequences.ghojeong;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question {

	public static void weaveLists(LinkedList<Integer> leftList, LinkedList<Integer> rightList,
			ArrayList<LinkedList<Integer>> weavedSeq, LinkedList<Integer> prefixList) {

		if (leftList.size() == 0 || rightList.size() == 0) {
			LinkedList<Integer> weavedList = new LinkedList<Integer>();
			weavedList.addAll(prefixList);
			weavedList.addAll(leftList);
			weavedList.addAll(rightList);
			weavedSeq.add(weavedList);
			return;
		}

		int leftFirstNode = leftList.removeFirst();
		prefixList.addLast(leftFirstNode);
		weaveLists(leftList, rightList, weavedSeq, prefixList);
		prefixList.removeLast();
		leftList.addFirst(leftFirstNode);

		int rightFirstNode = rightList.removeFirst();
		prefixList.addLast(rightFirstNode);
		weaveLists(leftList, rightList, weavedSeq, prefixList);
		prefixList.removeLast();
		rightList.addFirst(rightFirstNode);
	}

	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> allSeq = new ArrayList<LinkedList<Integer>>();

		if (node == null) {
			allSeq.add(new LinkedList<Integer>());
			return allSeq;
		}

		LinkedList<Integer> prefixList = new LinkedList<Integer>();
		prefixList.add(node.data);

		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

		for (LinkedList<Integer> leftList : leftSeq) {
			for (LinkedList<Integer> rightList : rightSeq) {
				ArrayList<LinkedList<Integer>> weavedSeq = new ArrayList<LinkedList<Integer>>();
				weaveLists(leftList, rightList, weavedSeq, prefixList);
				allSeq.addAll(weavedSeq);
			}
		}
		return allSeq;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(100);
		int[] array = { 100, 50, 20, 75, 150, 120, 170 };
		for (int a : array) {
			node.insertInOrder(a);
		}
		ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}

}
