class Solution {
    Boolean[][][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n][n];
        return dfs(s, 0, 0, 0);
    }

    private boolean dfs(String s, int index, int l, int r) {
        if (index == s.length()) {
            return l == r;
        }

        if (r > l) {
            return false;
        }
        if (memo[index][l][r] != null) {
            return memo[index][l][r];
        }

        if (s.charAt(index) == '(') {
            
            return memo[index][l][r] = dfs(s, index+1, l+1, r);
        }
        if (s.charAt(index) == ')') {
            return memo[index][l][r] = dfs(s, index+1, l, r+1);
        }
        
        return memo[index][l][r] =  dfs(s, index+1, l+1, r) || dfs(s, index+1, l, r+1) || dfs(s, index+1, l, r);
    }
}
