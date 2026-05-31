class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        boolean[][] isPalindromic = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++){
            isPalindromic[i][i] = true;
            for (int j = i+1; j <= s.length(); j++) {
                if (isPalindromic[i][j-1] || isPalindrome(s, i, j)) {
                    isPalindromic[i][j-1] = true;
                    String tmp = s.substring(i, j);
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
