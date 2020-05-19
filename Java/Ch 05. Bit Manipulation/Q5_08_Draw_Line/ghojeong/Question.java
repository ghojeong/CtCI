package Q5_08_Draw_Line.ghojeong;

public class Question {
	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			System.out.print(((b >> i) & 1));
		}
	};

	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x += 8) {
				byte b = screen[(width * y + x) / 8];
				printByte(b);
			}
			System.out.println();
		}
	}

	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int fromByte = (y * width + x1) / 8;
		int toByte = (y * width + x2) / 8;

		for (int i = fromByte; i <= toByte; i++) {
			screen[i] = (byte) 0xFF;
		}
		screen[fromByte] &= (byte) (0xFF >>> (x1 % 8));
		screen[toByte] &= (byte) (0xFF << (7 - (x2 % 8)));
	}

	public static void main(String[] args) {
		int width = 8 * 1;
		int height = 2;
		for (int y = 0; y < height; y++) {
			for (int x1 = 0; x1 < width; x1++) {
				for (int x2 = x1; x2 < width; x2++) {
					byte[] screen = new byte[width * height / 8];
					System.out.println("\nwidth:" + width + ", x1:" + x1 + ", x2:" + x2 + ", y:" + y);
					drawLine(screen, width, x1, x2, y);
					printScreen(screen, width);
				}
			}
		}
	}

}
