class TriNode {
    TriNode[] children = new TriNode[26];
    boolean isEndOfWord = false;
}

class Trie {

    TriNode root;

    public Trie() {
        root = new TriNode();
    }

    public void insert(String word) {
        TriNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TriNode();
            }

            node = node.children[ch - 'a'];
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TriNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (node.children[ch - 'a'] == null)
                return false;

            node = node.children[ch - 'a'];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TriNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}