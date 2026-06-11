class Solution {
    public int numIslands(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int count = 0;
        DSU dsu = new DSU(rLen*cLen);
        Set<Integer> set = new HashSet<>();
        int[][] dirs = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                
                count++;
                for (int[] dir : dirs) {
                    int r = dir[0] + i;
                    int c = dir[1] + j;

                    if (r >= 0 && c >= 0 && r<rLen && c < cLen) {
                        if (grid[r][c] == '0') {
                            continue;
                        }
                        if (dsu.union(r*cLen+c, i*cLen+j)) {
                            count--;
                        }
                    }
                }
            }
        }

        return count;
    }

    private class DSU {
        int[] parent;
        DSU(int n ) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }

            parent[px] = py;
            return true;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
    }
}
