class Solution {
    // public int numDecodings(String s) {
    //     if (s.length() == 0) {
    //         return 1;
    //     }

    //     if (s.charAt(0) == '0') {
    //         return 0;
    //     }

    //     if (s.length() > 1 && (s.charAt(0) < '2' && (s.charAt(1) <= '9') || s.charAt(0) == '2' && s.charAt(1) <= '6')) {
    //         return numDecodings(s.substring(1, s.length())) + numDecodings(s.substring(2, s.length()));
    //     }

    //     return numDecodings(s.substring(1, s.length()));
    // }

    // Map<String,Integer> map = new HashMap<>();

    // public int numDecodings(String s) {
    //     if (s.length() == 0) {
    //         return 1;
    //     }

    //     if (s.charAt(0) == '0') {
    //         return 0;
    //     }

    //     if (map.containsKey(s)) {
    //         return map.get(s);
    //     }

    //     if (s.length() > 1 && (s.charAt(0) < '2' && (s.charAt(1) <= '9') || s.charAt(0) == '2' && s.charAt(1) <= '6')) {
    //         map.put(s, numDecodings(s.substring(1, s.length())) + numDecodings(s.substring(2, s.length())));
    //     } else {
    //         map.put(s, numDecodings(s.substring(1, s.length())));
    //     }

    //     return map.get(s);
    // }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if (i < s.length() - 1 && (s.charAt(i) < '2' && (s.charAt(i+1) <= '9') || s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
        }

        return dp[0];
    }
}
