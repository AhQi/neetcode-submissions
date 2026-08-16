class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        memo = new Integer[n][m];

        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        int n = s.length();
        int m = t.length();
        if (j == m) {
            //System.out.println(i + ":" + j +":"+"1");
            return 1;
        }
        if (i >= n) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int ans = 0;

        if (s.charAt(i) == t.charAt(j)) {
            ans += dfs(s, t, i+1, j+1);
        } 

        ans += dfs(s, t, i+1, j);

        return memo[i][j] = ans;
    }
}
