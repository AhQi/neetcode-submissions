class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        DSU dsu = new DSU(r*c+1);
        int count = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c ; col++) {
                if (grid[row][col] != '1') {
                    continue;
                }

                count++;
                int[][] dirs = new int[][]{{1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
                };

                for (int[] dir : dirs) {
                    int i = row + dir[0];
                    int j = col + dir[1];

                    if (i < r && j < c && i >= 0 && j >= 0) {
                        if (grid[i][j] == '0') {
                            continue;
                        }

                        if (dsu.union(i*c+j, row*c+col)) {
                            count--;
                        }
                    }
                }
            }
        }

        return count;
    }

    private class DSU {
        int[] rank;
        int[] parent;
        DSU(int n) {
            rank = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }

            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[py] > rank[px]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }
}
