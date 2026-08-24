
class PrefixTree {
    private static class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }
}
