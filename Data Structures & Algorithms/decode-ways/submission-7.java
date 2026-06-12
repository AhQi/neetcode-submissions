class Solution {
    Map<String, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return decode(s);
    }

    private int decode(String s) {
    if (s.length() == 0) return 1;
    if (s.charAt(0) == '0') return 0;
    
    if (map.get(s) != null) {
        return map.get(s);
    }
    

    int cnt = decode(s.substring(1));
    if (s.length() >= 2) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
            cnt += decode(s.substring(2));
        }
    }

    map.put(s, cnt);
    return cnt;
}
}
