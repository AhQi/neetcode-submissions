class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prev = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                res++;
                prev = Math.min(prev, intervals[i][1]);
            } else {
                prev = intervals[i][1];
            }
        }

        return res;
    }
}
