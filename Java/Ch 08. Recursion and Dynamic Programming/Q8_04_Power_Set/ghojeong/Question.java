package Q8_04_Power_Set.ghojeong;

import java.util.*;

public class Question {

	public static ArrayList<ArrayList<Integer>> getSubsetsA(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if (set.size() == index) { // Base case - add empty set
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsetsA(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

	public static ArrayList<ArrayList<Integer>> getSubsetsB(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsetsA = getSubsetsA(list, 0);
		ArrayList<ArrayList<Integer>> subsetsB = getSubsetsB(list);
		System.out.println(subsetsA.toString());
		System.out.println(subsetsB.toString());
	}

}
