class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] == b[0]) {
                return a[1] < b[1] ? -1 : 1;
            } else {
                return 1;
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
