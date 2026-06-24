class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for (int i = s.length()-1;i>=0; i--) {
            dp[i] = false;
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i + wordLen > s.length()) {
                    continue;
                }
                if(word.equals(s.substring(i, i + wordLen)) &&
                    dp[i+wordLen]
                ) {
                    dp[i] = dp[i+wordLen];
                }
                if(dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
