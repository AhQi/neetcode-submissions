class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }

    private class DSU {
        int[] parent;
        int[] rank;

        DSU (int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean union(int x, int y) {
            int px = find(parent[x]);
            int py = find(parent[y]);
            if (px == py) {
                return true;
            }

            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return false;
        }

        int find(int x) {
            int px = parent[x];

            if (px == x) {
                return px;
            }

            parent[x] = find(px);
            return parent[x];
        }
    }
}
