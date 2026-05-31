class Solution {
    public List<List<String>> partition(String s) {
        return traverse(s, "", new ArrayList<>());
    }

    private List<List<String>> traverse(String s, String candidate, List<String> subString) {
        final List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            if (isPalindrome(candidate)) {
                subString.add(candidate);
                result.add(new ArrayList<>(subString));
                subString.remove(subString.size() - 1);
            }
            
            
            return result;
        }
        // cur subString is palindrome
        if (isPalindrome(candidate)) {
            subString.add(candidate);
            result.addAll(traverse(s.substring(1, s.length()), s.substring(0,1), subString));
            subString.remove(subString.size() - 1);
        }

        // not palindrome
        result.addAll(traverse(s.substring(1, s.length()), candidate + s.substring(0,1), subString));

        return result;

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
