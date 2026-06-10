class Solution {
    public void solve(char[][] board) {
        Queue<Integer[]> queue = new LinkedList<>();
        int rowLen = board.length;
        int colLen = board[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < rowLen; i ++) {
            if (board[i][0] == 'O') {
                queue.offer(new Integer[]{i, 0});
            }
            if (board[i][colLen-1] == 'O') {
                queue.offer(new Integer[]{i, colLen-1});
            }
            
            
        }
        for (int j = 0; j < colLen; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new Integer[]{0, j});
            }
            if (board[rowLen - 1][j] == 'O') {
                queue.offer(new Integer[]{rowLen - 1, j});
            }
            
            
        }

        while(!queue.isEmpty()) {
            Integer[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            board[r][c] = 'D';

            for (int[] dir : dirs) {
                int newR = r+dir[0];
                int newC = c+dir[1];
                if (newR >= 0 && newR < rowLen && newC >= 0 && newC < colLen &&
                board[newR][newC] == 'O') {
                    queue.offer(new Integer[]{newR, newC});
                } 
            }
            
        }

        for (int i = 0; i < rowLen; i ++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }
}