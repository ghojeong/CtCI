
public class Main {
    public static void main(String[] args){
        Trie trie = new Trie();
        // insert 메서드
        trie.insert("PI");
        trie.insert("PIE");
        trie.insert("POW");
        trie.insert("POP");
        // Contains 메서드
        // Delete 메서드
        System.out.println(trie.contains("PI"));
        System.out.println(trie.contains("PIE"));
        trie.delete("PIE");
        System.out.println(trie.contains("PIE"));
        trie.delete("POP");

        trie.delete("PO");//error
    }
}