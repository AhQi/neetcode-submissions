class Solution {
    Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new Integer[m][n];
        int maxPath = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int maxPath = 1;
        int cur = matrix[i][j];
        if (i + 1 < m && cur < matrix[i+1][j]) {
            maxPath = Math.max(maxPath, 1+dfs(matrix, i+1, j));
        }
        if (j + 1 < n && cur < matrix[i][j+1]) {
            maxPath = Math.max(maxPath, 1+dfs(matrix, i, j+1));
        }
        if (i - 1 >= 0 && cur < matrix[i-1][j]) {
            maxPath = Math.max(maxPath, 1+dfs(matrix, i-1, j));
        }
        if (j - 1 >= 0 && cur < matrix[i][j-1]) {
            maxPath = Math.max(maxPath, 1+dfs(matrix, i, j-1));
        }

        memo[i][j] = maxPath;

        return maxPath;
    }
}
