class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int dummy = row*col;
        DSU dsu = new DSU(dummy+1);

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] != 'O') {
                    continue;
                }

                if (r == 0 || c == 0 || r == row - 1 || c == col - 1) {
                    dsu.union(r*col+c, dummy);
                }

                if (r+1 < row && board[r+1][c] == 'O') {
                    dsu.union((r+1)*col+c, r*col+c);
                }
                if(c+1 < col && board[r][c+1] == 'O') {
                    dsu.union(r*col+c+1, r*col+c);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] != 'O') {
                    continue;
                }

                if (dsu.find(r*col+c) != dsu.find(dummy)) {
                    board[r][c] = 'X';
                }
            }
        }
        
    }

    private class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            
        }
        int find(int x) {
                int px = parent[x];
                if (px == x) {
                    return x;
                }

                parent[x] = find(px);
                return parent[x];
            }
            void union(int x, int y) {
                int px = find(x);
                int py = find(y);

                if (px == py) {
                    return;
                }

                if (rank[px] < rank[py]) {
                    parent[px] = py;
                    return;
                }
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                    return;
                }

                parent[px] = py;
                rank[py]++;


            }
    }
}
