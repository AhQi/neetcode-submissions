class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (traverse(grid, visited, i, j)) {
                    total++;
                }
            }
        }

        return total;
    }

    private boolean traverse(char[][] grid, int[][] visited, int i, int j) {
        if (grid[i][j] == '0' || visited[i][j] == 1) {
            return false;
        }

        visited[i][j] = 1;
        if (i + 1 < grid.length) {
            traverse(grid, visited, i+1, j);
        }
        if (j+1 < grid[0].length) {
            traverse(grid, visited, i, j+1);
        }
        if (i-1 >= 0) {
            traverse(grid, visited, i-1, j);
        }
        if (j-1 >= 0) {
            traverse(grid, visited, i, j-1);
        }
        return true;
    }
}
