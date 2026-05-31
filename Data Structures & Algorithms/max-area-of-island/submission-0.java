class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, traverse(grid, i, j));
            }
        }

        return maxArea;
    }

    private int traverse(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0;
        if (i + 1 < grid.length) {
            area += traverse(grid, i+1, j);
        }
        if (j+1 < grid[0].length) {
            area += traverse(grid, i, j+1);
        }
        if (i-1 >= 0) {
            area += traverse(grid, i-1, j);
        }
        if (j-1 >= 0) {
            area += traverse(grid, i, j-1);
        }
        return area;
    }
}
