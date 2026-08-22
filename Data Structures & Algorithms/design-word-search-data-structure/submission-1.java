class WordDictionary {
    private static class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }

            cur = cur.children[ch - 'a'];
        }

        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode current) {
        if (index == word.length() && current.isEndOfWord) {
            return true;
        }
        if (index >= word.length()) {
            return false;
        }
        TrieNode cur = current;
        char ch = word.charAt(index);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null && dfs(word, index+1, current.children[i])) {
                    return true;
                }
            }
            return false;
            
        } else {
            if (cur.children[ch - 'a'] == null) {
                return false;
            }

            return dfs(word, index + 1, cur.children[ch - 'a']);
        }
    }
}
