class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        boolean[][] isPalindromic = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++){
            isPalindromic[i][i] = true;
            for (int l = 1; i+l <= s.length(); l++) {
                if (isPalindromic[i][i+l] || isPalindrome(s, i, i+l)) {
                    isPalindromic[i][i+l] = true;
                    String tmp = s.substring(i, i+l);
                    if (tmp.length() > longest.length()) {
                        longest = tmp;
                    }
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            if (s.charAt(i + start) != s.charAt(end - 1 - i)) {
                return false;
            }

            
        }
        return true;
    }
}
