class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] prerequisite : edges) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            neighbors.get(preCourse).add(course);
            neighbors.get(course).add(preCourse);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});

        int finish = 0;
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            finish++;
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            visited.add(node);
            for(Integer neighbor : neighbors.get(node)) {
                if (neighbor == parent) {
                    continue;
                }
                if(visited.contains(neighbor)){
                    return false;
                }
                queue.offer(new int[]{neighbor, node});
            }
        }
        return finish == n;
    }
}
