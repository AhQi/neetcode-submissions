class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(interval);
                continue;
            } 

            if (interval[0] > newInterval[1]) {
                result.add(new int[]{newInterval[0], newInterval[1]});
                newInterval[0] = interval[0];
                newInterval[1] = interval[1];
                continue;
            }

            newInterval[0] = Math.min(newInterval[0], interval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);

    }
}
