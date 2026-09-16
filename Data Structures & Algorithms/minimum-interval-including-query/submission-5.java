class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> queryIndexMap = new HashMap<>();
        Map<Integer, Integer> queryIntervalMap = new HashMap<>();
        int[] result = new int[queries.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        

        for (int i = 0; i < queries.length; i++) {
            queryIndexMap.put(i, queries[i]);
        }

        Arrays.sort(queries);
        int i = 0;
        for (int query : queries) {
            if (queryIntervalMap.get(query) != null) {
                continue;
            }
            
            
            while (i < intervals.length && intervals[i][0] <= query) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[] {r-l+1, r});
                i++;
            }

            while(!minHeap.isEmpty() && query > minHeap.peek()[1]) {
                minHeap.poll();
            }
            queryIntervalMap.put(query, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        for (int ii = 0; ii < queries.length; ii++) {
                result[ii] = queryIntervalMap.get(queryIndexMap.get(ii));
            }


        return result;

    }
}
