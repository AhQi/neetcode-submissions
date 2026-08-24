class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode current = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];

            }

            current.word = word;
        }
    }

    List<String> res;
    
    public List<String> findWords(char[][] board, String[] words) {
        // build a trie with words, and also record the max length of the word in words.
        // iterate every grid in board, and run a dfs on the grid.
        TrieNode trie = new TrieNode();
        
        for (String word : words) {
            trie.insert(word);
        }

        int ROWS = board.length, COLS = board[0].length;
        res = new ArrayList<>();
        boolean[][] visit = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, visit, trie, r, c);
            }
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, TrieNode node, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        if (node.children[board[i][j] - 'a'] != null) {
            node = node.children[board[i][j] - 'a'];
        } else {
            return;
        }

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        visited[i][j] = true;
        dfs(board, visited, node, i+1, j);
        dfs(board, visited, node, i-1, j);
        dfs(board, visited, node, i, j+1);
        dfs(board, visited, node, i, j-1);
        visited[i][j] = false;



    }
}
