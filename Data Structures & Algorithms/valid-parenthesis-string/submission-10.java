class Solution {
    Boolean[][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int index, int balance) {
        if (index == s.length()) {
            return balance == 0;
        }

        if (balance < 0) {
            return false;
        }
        if (memo[index][balance] != null) {
            return memo[index][balance];
        }

        if (s.charAt(index) == '(') {
            
            return memo[index][balance] = dfs(s, index+1, balance+1);
        }
        if (s.charAt(index) == ')') {
            return memo[index][balance] = dfs(s, index+1, balance - 1);
        }
        
        return memo[index][balance] =  dfs(s, index+1, balance+1) || dfs(s, index+1, balance - 1) || dfs(s, index+1, balance);
    }
}
