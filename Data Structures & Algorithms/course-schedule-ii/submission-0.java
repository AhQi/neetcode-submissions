class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<Integer> order = new ArrayList<>();
       int finished = 0;
       int[] indegree = new int[numCourses];
       List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            indegree[course]++;
            adj.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            finished++;
            int c = queue.poll();
            order.add(c);
            for(Integer course : adj.get(c)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        return finished == numCourses ? (order.stream()
                     .mapToInt(Integer::intValue) // 轉為 IntStream
                     .toArray()) : new int[0];
    }
}
