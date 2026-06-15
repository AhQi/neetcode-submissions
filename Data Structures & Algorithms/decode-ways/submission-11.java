class Solution {
    Map<String, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return decode(s);
    }

    public int decode(String s) {
        if (map.get(s) != null) {
            return map.get(s);
        }
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        
        if (s.length() > 1 && (s.charAt(0) < '2' || (s.charAt(0) == '2' && s.charAt(1) < '7'))) {
            int cnt = decode(s.substring(1, s.length())) + decode(s.substring(2, s.length()));
            map.put(s, cnt);
            return cnt;
        }

        int cnt = decode(s.substring(1, s.length()));
        map.put(s, cnt);
        return cnt;
    }
}
