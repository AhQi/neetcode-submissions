class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int num : hand) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }

        for (int num : hand) {
            if (cnt.get(num) == 0) {
                continue;
            }

            for (int i = num; i < num + groupSize; i++) {
                if (cnt.getOrDefault(i, 0) == 0) {
                    return false;
                }

                cnt.put(i, cnt.get(i) - 1);
            }
        }

        return true;
    }
}
