class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        DSU dsu = new DSU(r*c+1);

        for (int i = 0 ; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }

                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    dsu.union(i*c+j, r*c);
                }

                if (i+1 < r && board[i+1][j] == 'O') {
                    dsu.union((i+1)*c+j, i*c+j);
                }
                if (j+1 < c && board[i][j+1] == 'O') {
                    dsu.union(i*c+j+1, i*c+j);
                }
            }
        }
        int dummy = dsu.find(r*c);
        for (int i = 0 ; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }

                if (dsu.find(i*c+j) != dummy){
                    board[i][j] = 'X';
                }
            }
        }
    }

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
    }
}
