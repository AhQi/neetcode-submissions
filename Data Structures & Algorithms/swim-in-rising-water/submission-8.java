class Solution {
    Integer localMax;
    public int swimInWater(int[][] grid) {
        // thought: find a path to reach bottom right grid,
        // we should try our best to find the path has the max number is as minimum as possible.
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int minH = grid[0][0];
        int maxH = grid[0][0];
        
        for (int[] row : grid) {
            for (int node : row) {
                maxH = Math.max(maxH, node);
                minH = Math.min(minH, node);
            }
        }

        for (int t = minH; t < maxH; t++) {
            if (dfs(grid, visited, 0, 0, t)) {
                return t;
            }
            for (int r = 0; r < n; r++) {
                Arrays.fill(visited[r], false);
            }
        }

        return maxH;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int x, int y, int target) {
        int n = grid.length;
        if (x >= n || y >= n || x < 0 || y < 0 || grid[x][y] > target || visited[x][y]) {
            return false;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return true;
        }

        


        
        visited[x][y] = true;
        return dfs(grid, visited, x+1, y, target) || dfs(grid, visited, x, y+1, target) ||
        dfs(grid, visited, x-1, y, target) || dfs(grid, visited, x, y-1, target);
        
    }
}
