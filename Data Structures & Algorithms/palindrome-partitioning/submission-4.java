class Solution {
    public List<List<String>> partition(String s) {
        return traverse(s, 0, new ArrayList<>());
    }

    private List<List<String>> traverse(String s, int begin, List<String> path) {
        final List<List<String>> results = new ArrayList<>();
        if (s.length() == begin) {
            results.add(new ArrayList<>(path));

            return results;
        }
        
        for (int end = begin + 1; end <= s.length(); end++) {
            String subStr = s.substring(begin, end);
            if (isPalindrome(subStr)) {
                path.add(subStr);
                results.addAll(traverse(s, end, path));
                path.remove(path.size() - 1);
            }
        }

        return results;

    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
