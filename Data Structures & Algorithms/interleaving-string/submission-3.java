class Solution {
    Boolean memo[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        if (i+j == s3.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean can = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            can = dfs(s1, s2, s3, i+1, j);
        }

        if (!can && j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            can = dfs(s1, s2, s3, i, j+1);
        }

        memo[i][j] = can;

        return can;
    }
}
