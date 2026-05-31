class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (traverse(board, word, new boolean[board.length][board[0].length], i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean traverse(char[][] board, String word, boolean[][] visited, int row, int col, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }

        if (board[row][col] == word.charAt(wordIdx) && wordIdx + 1 == word.length()) {
            return true;
        }

        if (board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        visited[row][col] = true;
        // left
        if (col > 0 && !visited[row][col - 1]) {
            if (traverse(board, word, visited, row, col - 1, wordIdx + 1)) {
                return true;
            }
        }

        // right
        if (col < board[0].length - 1 && !visited[row][col + 1]) {
            if (traverse(board, word, visited, row, col + 1, wordIdx + 1)) {
                return true;
            }
        }

        // up
        if (row > 0 && !visited[row - 1][col]) {
            if (traverse(board, word, visited, row - 1, col, wordIdx + 1)) {
                return true;
            }
        }

        // down
        if (row < board.length - 1 && !visited[row + 1][col]) {
            if (traverse(board, word, visited, row + 1, col, wordIdx + 1)) {
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }
}
