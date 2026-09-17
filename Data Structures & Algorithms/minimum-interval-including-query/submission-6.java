class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> queryIntervalMap = new HashMap<>();
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);

        int i = 0;
        for (int query : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(new int[] {intervals[i][1] - intervals[i][0]+1, intervals[i][1]});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                int[] top = minHeap.peek();
                //System.out.println(query+"|"+top[1]);
                queryIntervalMap.put(query, top[0]);
            } else {
                queryIntervalMap.put(query, -1);
            }
        }

        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = queryIntervalMap.get(queries[j]);
        }

        return result;
    }
}
