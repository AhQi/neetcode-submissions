class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        DSU dsu = new DSU(r*c+1);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    dsu.union(r*c, i*c+j);
                }

                if (i+1 < r && board[i+1][j] == 'O') {
                    dsu.union(i*c+j, (i+1)*c+j);
                }
                if (j+1 < c && board[i][j+1] == 'O') {
                    dsu.union(i*c+j, i*c+j+1);
                }
            }
        }

        int dummyParent = dsu.find(r*c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                if (dsu.find(i*c+j) != dummyParent) {
                    board[i][j] = 'X';
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
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return;
            }

            if (rank[x] < rank[y]) {
                parent[px] = py;
            } else if (rank[x] > rank[y]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
