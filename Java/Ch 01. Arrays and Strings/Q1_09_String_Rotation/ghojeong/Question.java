package Q1_09_String_Rotation.ghojeong;

public class Question {
	public static boolean isSubstring(String big, String small) {
		return big.contains(small);
	}

	public static boolean isRotation(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		if (s1Len < 1 | s2Len < 1 | s1Len != s2Len) {
			return false;
		}
		return isSubstring(s1 + s1, s2);
	}

	public static void main(String[] args) {
		String[][] pairs = { { "apple", "pleap" }, { "waterbottle", "erbottlewat" }, { "camera", "macera" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
