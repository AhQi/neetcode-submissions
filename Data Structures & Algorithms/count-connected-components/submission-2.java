class Solution {
    public int countComponents(int n, int[][] edges) {
        // disjoint set union
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            //System.out.println(i + ":" + dsu.find(i));
            set.add(dsu.find(i));
        }

        return set.size();
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

        void union(int x, int y) {
            int px = find(parent[x]);
            int py = find(parent[y]);
            if (px == py) {
                return;
            }

            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
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
