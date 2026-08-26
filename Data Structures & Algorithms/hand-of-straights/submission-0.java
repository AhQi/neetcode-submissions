class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> tm = new TreeMap<>();

        for (int num : hand) {
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }
        System.out.println(tm);

        while(tm.size() > 0) {
            int cnt = 0;
            int prev = -1;
            List<Integer> remove = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
                
                if (prev != -1 && entry.getKey() != prev + 1) {
                    return false;
                }
                prev = entry.getKey();
                cnt++;
                tm.put(entry.getKey(), entry.getValue()-1);
                if (entry.getValue() == 0) {
                    remove.add(entry.getKey());
                }

                if (cnt == groupSize) {
                    break;
                }
            }

            if (cnt != groupSize) {
                return false;
            }

            for (Integer key : remove) {
                tm.remove(key);
            }
        }

        return true;
    }
}
