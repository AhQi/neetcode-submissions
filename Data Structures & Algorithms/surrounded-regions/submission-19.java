class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        DSU dsu = new DSU(r*c+1);
        
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c ; col++) {
                if (board[row][col] != 'O') {
                    continue;
                }

                if (row == 0 || col == 0 || row == r - 1 || col == c - 1) {
                    dsu.union(row*c + col,  r*c);
                }

                if (row + 1 < r && board[row+1][col] == 'O') {
                    dsu.union((row+1)*c + col, row*c + col);
                }
                if (col + 1 < c && board[row][col+1] == 'O') {
                    dsu.union(row*c + col+1, row*c + col);
                }
            }
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c ; col++) {
                if (board[row][col] != 'O') {
                    continue;
                }

                if (dsu.find(row*c + col) != dsu.find(r*c)) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0 ; i < n; i++) {
                parent[i] = i;
            }
        }
        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void union(int x, int y) {
            int px = find(parent[x]);
            int py = find(parent[y]);
            parent[px] = py;
        }
    }
}
