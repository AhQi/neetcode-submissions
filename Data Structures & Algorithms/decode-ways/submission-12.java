class Solution {
    public int numDecodings(String s) {
        return decode(s);
    }

    public int decode(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            if (i < s.length()-1 && (s.charAt(i) < '2' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    // public int decode(String s) {
    //     if (map.get(s) != null) {
    //         return map.get(s);
    //     }
    //     if (s.length() == 0) {
    //         return 1;
    //     }
    //     if (s.charAt(0) == '0') {
    //         return 0;
    //     }

        
    //     if (s.length() > 1 && (s.charAt(0) < '2' || (s.charAt(0) == '2' && s.charAt(1) < '7'))) {
    //         int cnt = decode(s.substring(1, s.length())) + decode(s.substring(2, s.length()));
    //         map.put(s, cnt);
    //         return cnt;
    //     }

    //     int cnt = decode(s.substring(1, s.length()));
    //     map.put(s, cnt);
    //     return cnt;
    // }
}
