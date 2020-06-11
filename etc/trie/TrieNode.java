import java.util.HashMap;
import java.util.Map;
public class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;
    Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }
    boolean isLastChar() {
        return this.isLastChar;
    }
    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}