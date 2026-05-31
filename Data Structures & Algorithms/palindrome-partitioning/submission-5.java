class Solution {
    public List<List<String>> partition(String s) {
        return traverse(s, 0, new ArrayList<>());
    }

    private List<List<String>> traverse(String s, int start, List<String> path) {
        final List<List<String>> result = new ArrayList<>();
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return result;
        }

        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i+1))) {
                path.add(s.substring(start, i+1));
                result.addAll(traverse(s, i+1, path));
                path.remove(path.size() - 1);
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }


}
