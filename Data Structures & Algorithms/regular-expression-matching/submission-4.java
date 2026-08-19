class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        int n = Math.max(s.length(), p.length());
        memo = new Boolean[n+1][n+1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (j == p.length()) {
            return s.length() == i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean firstMatch =
        i < s.length() && (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.' ));

        boolean can = false;

        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            can |= firstMatch && dfs(s, p, i + 1, j);
            can |= dfs(s, p, i, j+2);
        } else {
            if (firstMatch) {
              can |= dfs(s, p, i + 1, j+1);
            }
        }
        return memo[i][j] = can;
    }
}
