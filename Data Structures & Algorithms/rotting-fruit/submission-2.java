class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                
            }
        }

        int elapsed = bfs(grid, q, freshOranges);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
                
            }
        }

        return elapsed;
    }

    private int bfs(int[][] grid, Queue<int[]> q, int freshOranges) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int elapsedTime = 0;
        while (q.size() > 0) {
            int cur = q.size();
            for (int i = 0; i < cur; i++) {
                int [] node = q.poll();
                int row = node[0];
                int col = node[1];

                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= m || c >= n || r < 0 ||
                        c < 0 || grid[r][c] != 1) {
                        continue;
                    }
                    q.add(new int[]{r, c});
                    grid[r][c] = 2;
                }
            }
            if (q.size() > 0) {
                elapsedTime++;
            }
        }


        return elapsedTime;
    }
}
