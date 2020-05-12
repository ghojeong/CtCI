package Q5_02_Binary_to_String.ghojeong;

import java.util.Scanner;

public class Question {
	public static String double2Binary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder builder = new StringBuilder();
		builder.append(".");
		while (num > 0) {
			if (builder.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				builder.append(1);
				num = r - 1;
			} else {
				builder.append(0);
				num = r;
			}
		}
		return builder.toString();
	}

	public static String double2Binary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder builder = new StringBuilder();
		double frac = 0.5;
		builder.append(".");
		while (num > 0) {
			if (builder.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				builder.append(1);
				num -= frac;
			} else {
				builder.append(0);
			}
			frac /= 2;
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			try {
				double num = Double.parseDouble(scan.nextLine());
				System.out.println(double2Binary(num) + " " + double2Binary2(num) + '\n');
			} catch (Exception e) {
				System.out.println(e + "\n");
			}
		}
	}
}
