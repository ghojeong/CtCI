package Q5_08_Draw_Line.ghojeong;

public class Question {
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0) {
			first_full_byte++;
		}

		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) {
			last_full_byte--;
		}

		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}

		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

		// Set start and end of line
		if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}

	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x += 8) {
				byte b = screen[(width * y + x) / 8];
				for (int i = 7; i >= 0; i--) {
					char c = ((b >> i) & 1) == 1 ? '1' : '#';
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int width = 8 * 1;
		int height = 1;
		for (int y = 0; y < height; y++) {
			for (int x1 = 0; x1 < width; x1++) {
				for (int x2 = x1; x2 < width; x2++) {
					byte[] screen = new byte[width * height / 8];

					System.out.println("width:" + width + ", x1:" + x1 + ", x2:" + x2 + ", y:" + y);
					drawLine(screen, width, x1, x2, y);
					printScreen(screen, width);
					System.out.println();
				}
			}
		}
	}

}
