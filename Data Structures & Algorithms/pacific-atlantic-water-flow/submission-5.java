class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        Queue<Integer[]> pacQueue = new LinkedList<>();
        Queue<Integer[]> atlQueue = new LinkedList<>();
        boolean[][] pacVisited = new boolean[ROWS][COLS];
        boolean[][] atlVisited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            pacVisited[r][0] = true;
            pacQueue.offer(new Integer[]{r, 0});

            atlVisited[r][COLS - 1] = true;
            atlQueue.offer(new Integer[]{r, COLS - 1});
        }

        for (int c = 0; c < COLS; c++) {
            pacVisited[0][c] = true;
            pacQueue.offer(new Integer[]{0, c});

            atlVisited[ROWS - 1][c] = true;
            atlQueue.offer(new Integer[]{ROWS - 1, c});
        }

        bfs(pacQueue, heights, pacVisited);
        bfs(atlQueue, heights, atlVisited);

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacVisited[r][c] && atlVisited[r][c]) {
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;

    }

    private void bfs(Queue<Integer[]> q, int[][] heights, boolean[][] visited) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ROWS = heights.length;
        int COLS = heights[0].length;

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= 0 && r < ROWS && c >= 0 && c < COLS
                && heights[row][col] <= heights[r][c]
                && !visited[r][c]) {
                    visited[r][c] = true;
                    q.offer(new Integer[]{r, c});
                }
            }
        }
    }
}
