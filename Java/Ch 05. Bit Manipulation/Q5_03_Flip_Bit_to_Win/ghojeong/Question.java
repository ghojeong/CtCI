package Q5_03_Flip_Bit_to_Win.ghojeong;

import java.util.Scanner;

public class Question {

	public static int num = 0;

	public static int flipBit(int a) {
		/* If all 1s, this is already the longest sequence. */
		if (~a == 0)
			return Integer.BYTES * 8;

		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		int pos = 0;
		int maxPos = 0;
		while (a != 0) {
			if ((a & 1) == 0) {
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			} else {
				currentLength++;
			}
			int length = previousLength + currentLength + 1;
			if (length > maxLength) {
				maxLength = length;
				if (currentLength > pos) {
					maxPos = currentLength;
				} else {
					maxPos = pos - currentLength;
				}
			}
			a >>>= 1;
			pos++;
		}
		num = num | (1 << maxPos);
		return maxLength;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			try {
				num = Integer.parseInt(scan.nextLine());
				System.out.println(Integer.toBinaryString(num));
				int maxLength = flipBit(num);
				System.out.println(Integer.toBinaryString(num));
				System.out.println(maxLength + "\n");
			} catch (Exception e) {
				System.out.println(e + "\n");
			}
		}

	}

}
