public class Trie {
    private TrieNode rootNode;
    // [ 생성자 ]
    Trie() {
        rootNode = new TrieNode();
    }
    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }
    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);
            if (node == null)
            return false;
            thisNode = node;
        }
        return thisNode.isLastChar();
    }
    void delete(String word) {
        delete(this.rootNode, word, 0); 
    }
    private void delete(TrieNode thisNode, String word, int index) {
        char character = word.charAt(index);
        if(!thisNode.getChildNodes().containsKey(character))
        throw new Error("There is no [" + word + "] in this Trie.");
        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;
        if(index == word.length()) {
            if (!childNode.isLastChar())
            throw new Error("There is no [" + word + "] in this Trie.");
            childNode.setIsLastChar(false);
            if (childNode.getChildNodes().isEmpty())
            thisNode.getChildNodes().remove(character);
        }else {
            delete(childNode, word, index);
            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
            thisNode.getChildNodes().remove(character);
        }
    }
}