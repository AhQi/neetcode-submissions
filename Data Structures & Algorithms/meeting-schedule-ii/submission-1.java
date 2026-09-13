/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        int[][] events = new int[intervals.size()*2][2];
        int index = 0;
        for (Interval interval : intervals) {
            events[index++] = new int[]{interval.start, 1};
            events[index++] = new int[]{interval.end, -1};
        }
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]); 
        });

        int current = 0;
        int maxRooms = 0;
        for (int[] event : events) {
            current += event[1];
            maxRooms = Math.max(maxRooms, current);
        }
        return maxRooms;
    }
}
