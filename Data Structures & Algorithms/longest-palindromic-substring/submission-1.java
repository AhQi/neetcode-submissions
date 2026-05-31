class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++) {
                if (isPalindrome(s, i, j)) {
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
