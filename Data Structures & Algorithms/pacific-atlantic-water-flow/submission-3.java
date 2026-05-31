class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean [][] pacVisited = new boolean[heights.length][heights[0].length];
        boolean [][] atlVisited = new boolean[heights.length][heights[0].length];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        // Check if it's able to reach pacific ocean
        for (int r = 0; r < heights.length; r++) {
            queue.offer(new int[]{r, 0});
            pacVisited[r][0] = true;
        }
        for (int c = 0; c < heights[0].length; c++) {
            queue.offer(new int[]{0, c});
            pacVisited[0][c] = true;
        }
        bfs(queue, heights, pacVisited, directions);
        
        for (int r = heights.length - 1; r >= 0 ; r--) {
            queue.offer(new int[]{r, heights[0].length - 1});
            atlVisited[r][heights[0].length - 1] = true;
        }
        for (int c = 0; c < heights[0].length; c++) {
            queue.offer(new int[]{heights.length - 1, c});
            atlVisited[heights.length - 1][c] = true;
        }
        bfs(queue, heights, atlVisited, directions);

        List<List<Integer>> result = new ArrayList<>();
        // Check which islands are able to reach both ocean
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacVisited[r][c] && atlVisited[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, int[][] heights, boolean [][] visited, int[][] dir) {
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int curHeight = heights[cur[0]][cur[1]];
            
            for (int i = 0; i < dir.length; i++) {
                int row = r + dir[i][0];
                int col = c + dir[i][1];

                if (row >= heights.length || row < 0 || col < 0
                || col >= heights[0].length
                || visited[row][col]
                || heights[r][c] > heights[row][col] ) {
                    continue;
                }

                visited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
    }
}
