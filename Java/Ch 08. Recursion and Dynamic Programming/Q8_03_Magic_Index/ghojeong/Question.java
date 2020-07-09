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
				start = mid + 1;
			} else {
				end = mid - 1;
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
		int[] array6 = { 0, 1, 2, 3, 4, 5 };
		int[] array0 = { 0, 0, 0, 0, 0, 0 };
		int[] array1 = { 1, 1, 1, 1, 1, 1 };
		int[] array2 = { 2, 2, 2, 2, 2, 2 };
		int[] array3 = { 3, 3, 3, 3, 3, 3 };
		int[] array4 = { 4, 4, 4, 4, 4, 4 };
		int[] array5 = { 5, 5, 5, 5, 5, 5 };
		int[] array7 = { -10, -9, 2, 2, 2, 2, 2, 200, 300, 4000, 50000 };
		int[] array8 = { -10, -9, 4, 4, 4, 6, 6, 200, 300, 4000, 50000 };

		System.out.println("array0: " + "brute:" + magicBrute(array0) + ", iterative:" + magicIterative(array0)
				+ ", recursive:" + magicRecursive(array0, 0, array0.length - 1));
		System.out.println("array1: " + "brute:" + magicBrute(array1) + ", iterative:" + magicIterative(array1)
				+ ", recursive:" + magicRecursive(array1, 0, array1.length - 1));
		System.out.println("array2: " + "brute:" + magicBrute(array2) + ", iterative:" + magicIterative(array2)
				+ ", recursive:" + magicRecursive(array2, 0, array2.length - 1));
		System.out.println("array3: " + "brute:" + magicBrute(array3) + ", iterative:" + magicIterative(array3)
				+ ", recursive:" + magicRecursive(array3, 0, array3.length - 1));
		System.out.println("array4: " + "brute:" + magicBrute(array4) + ", iterative:" + magicIterative(array4)
				+ ", recursive:" + magicRecursive(array4, 0, array4.length - 1));
		System.out.println("array5: " + "brute:" + magicBrute(array5) + ", iterative:" + magicIterative(array5)
				+ ", recursive:" + magicRecursive(array5, 0, array5.length - 1));
		System.out.println("array6: " + "brute:" + magicBrute(array6) + ", iterative:" + magicIterative(array6)
				+ ", recursive:" + magicRecursive(array6, 0, array6.length - 1));
		System.out.println("array7: " + "brute:" + magicBrute(array7) + ", iterative:" + magicIterative(array7)
				+ ", recursive:" + magicRecursive(array7, 0, array7.length - 1));
		System.out.println("array8: " + "brute:" + magicBrute(array8) + ", iterative:" + magicIterative(array8)
				+ ", recursive:" + magicRecursive(array8, 0, array8.length - 1));
	}

}
