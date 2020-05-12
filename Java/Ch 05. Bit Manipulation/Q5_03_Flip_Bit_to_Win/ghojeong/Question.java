package Q5_03_Flip_Bit_to_Win.ghojeong;

import java.util.Scanner;

public class Question {

	public static int flipBit(int num) {
		/* If all 1s, this is already the longest sequence. */
		if (~num == 0)
			return Integer.BYTES * 8;

		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (num != 0) {
			if ((num & 1) == 1) {
				currentLength++;
			} else if ((num & 1) == 0) {
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (num & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			int length = previousLength + currentLength + 1;
			if (length > maxLength) {
				maxLength = length;
			}
			num >>>= 1;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			try {
				int num = Integer.parseInt(scan.nextLine());
				System.out.println(Integer.toBinaryString(num));
				System.out.println(flipBit(num));
				System.out.println();
			} catch (Exception e) {
				System.out.println(e + "\n");
			}
		}

	}

}
