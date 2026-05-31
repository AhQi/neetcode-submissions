class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                traverse(grid, i, j, 0);
            }
        }
    }

    private void traverse(int[][] grid, int i, int j, int distance) {
        if (grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] != 2147483647 && grid[i][j] < distance) {
            return;
        }

        if (grid[i][j] != 0) {
            grid[i][j] = distance;
        }
        
        distance++;

        if (i + 1 < grid.length && grid[i+1][j] != 0) {
            traverse(grid, i+1, j, distance);
        }
        if (j+1 < grid[0].length && grid[i][j+1] != 0) {
            traverse(grid, i, j+1, distance);
        }
        if (i-1 >= 0 && grid[i-1][j] != 0) {
            traverse(grid, i-1, j, distance);
        }
        if (j-1 >= 0 && grid[i][j-1] != 0) {
            traverse(grid, i, j-1, distance);
        }
    }
}
