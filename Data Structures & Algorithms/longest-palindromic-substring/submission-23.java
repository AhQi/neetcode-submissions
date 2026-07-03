class Solution {
    public String longestPalindrome(String s) {
        int len = 1;
        int startIdx = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i+1;
            while (l < r && l >= 0 && r < n) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }

                if (r - l + 1 > len) {
                    len = r - l + 1;
                    startIdx = l;
                }

                l--;
                r++;

            }
        }

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;

            while (l <= r && l >= 0 && r < n) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }

                if (r - l + 1 > len) {
                    len = r - l + 1;
                    startIdx = l;
                }

                l--;
                r++;
            }
        }

        return s.substring(startIdx, startIdx+len);
    }
}
