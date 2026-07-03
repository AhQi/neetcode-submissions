class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        int n = s.length();
        if (index == n) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
        int cnt = decode(s, index+1);

        if (index+1 < n) {
            if ((s.charAt(index) == '1' && s.charAt(index+1) <= '9')
            || (s.charAt(index) == '2' && s.charAt(index+1) <= '6')) {
                cnt += decode(s, index+2);
            }
        }

        dp[index] = cnt;

        return cnt;
    }
}
