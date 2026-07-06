class Solution {
    public void solve(char[][] board) {
        int rLen = board.length;
        int cLen = board[0].length;
        int dummy = rLen * cLen;
        DSU dsu = new DSU(rLen * cLen+1);

        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (board[r][c] == 'X') {
                    continue;
                }
                if (r == 0 || c == 0 || r == rLen - 1 || c == cLen - 1 ) {
                    dsu.union(r * cLen + c, dummy);
                }

                if (r + 1 < rLen && board[r+1][c] == 'O') {
                    dsu.union((r+1)*cLen + c, r * cLen + c);
                }

                if (c + 1 < cLen && board[r][c+1] == 'O') {
                    dsu.union(r*cLen + c + 1, r * cLen + c);
                }
            }
        }

        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (board[r][c] != 'O') {
                    continue;
                }
                if (dsu.find(r*cLen + c) != dsu.find(dummy)) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    class DSU {
        int[] rank;
        int[] parent;
        DSU(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int x, int y) {
            int px = find(parent[x]);
            int py = find(parent[y]);
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
