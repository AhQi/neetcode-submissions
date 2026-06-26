class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Map<Integer, Boolean>> prereq = new HashMap<>();
        Map<Integer, List<Integer>> a = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new HashMap<>());
            a.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            prereq.get(course).put(preCourse, true);
            a.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Map<Integer, Boolean>> entry : prereq.entrySet()) {
            Integer course = entry.getKey();
            Map<Integer, Boolean> preCourses = entry.getValue();

            if (preCourses.isEmpty()) {
                queue.offer(course);
            }
        }

        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            for(Integer c : a.get(course)) {
                prereq.get(c).remove(course);
                if (prereq.get(c).isEmpty()) {
                    queue.offer(c);
                }
            }
        }

        for (Map.Entry<Integer, Map<Integer, Boolean>> entry : prereq.entrySet()) {
            Map<Integer, Boolean> preCourses = entry.getValue();

            if (!preCourses.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
