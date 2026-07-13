class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }

        edges.sort((a,b) -> Integer.compare(a[0], b[0]));

        int dist = 0;
        for (int[] edge : edges) {
            if (dsu.union(edge[1], edge[2])) {
                dist += edge[0];
            }
        }

        return dist;
        
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
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
        boolean union(int x, int y) {
            int px = find(parent[x]);
            int py = find(parent[y]);

            if (px == py) {
                return false;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }

            return true;
        }
    }
}
