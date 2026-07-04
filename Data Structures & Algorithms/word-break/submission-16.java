class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }

    private boolean helper(String s, List<String> wordDict) {
        int len = s.length();
        if (s.length() == 0) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean result = false;
        for (String word : wordDict) {
            int wordLen = word.length();
            if (word.length() > len || !word.equals(s.substring(0, wordLen))) {
                continue;
            }

            result |= helper(s.substring(wordLen, len), wordDict);
        }

        memo.put(s, result);

        return result;
    }
}
