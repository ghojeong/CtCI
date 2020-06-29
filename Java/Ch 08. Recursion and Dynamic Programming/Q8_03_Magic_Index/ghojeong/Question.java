package Q8_03_Magic_Index.ghojeong;

import java.util.Arrays;

public class Question {

	public static int magicBrute(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicIterative(int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] == mid) {
				return mid;
			} else if (array[mid] > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int magicRecursive(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicRecursive(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicRecursive(array, rightIndex, end);

		return right;
	}

	public static void main(String[] args) {
		// int[] array = { 0, 1, 2, 3, 4, 5 };
		int[] array = { 5, 5, 5, 5, 5, 5 };
		int brute = magicBrute(array);
		int itr = magicIterative(array);
		int rec = magicRecursive(array, 0, array.length - 1);
		System.out.println("brute:" + brute + ", iterative:" + itr + ", recursive:" + rec);
	}

}
