class Solution {
    // public int numDecodings(String s) {
    //     if (s.length() == 0) {
    //         return 1;
    //     }

    //     if (s.charAt(0) == '0') {
    //         return 0;
    //     }

    //     if (s.length() > 1 && (s.charAt(0) < '2' && (s.charAt(1) <= '9') || s.charAt(0) == '2' && s.charAt(1) <= '6')) {
    //         return decode(s.substring(1, s.length())) + decode(s.substring(2, s.length()));
    //     }

    //     return decode(s.substring(1, s.length()));
    // }

    Map<String,Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 1;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (s.length() > 1 && (s.charAt(0) < '2' && (s.charAt(1) <= '9') || s.charAt(0) == '2' && s.charAt(1) <= '6')) {
            map.put(s, numDecodings(s.substring(1, s.length())) + numDecodings(s.substring(2, s.length())));
        } else {
            map.put(s, numDecodings(s.substring(1, s.length())));
        }

        return map.get(s);
    }
}
