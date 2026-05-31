class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> nodeToAdjNodesMap = new HashMap<>();
        int[] visitedTime = new int[n+1];
        List<Node> queue = new ArrayList<>();
        int curTime = 0;

        for (int[] time : times) {
            List<Node> adjNodes = nodeToAdjNodesMap.getOrDefault(time[0], new ArrayList<>());
            adjNodes.add(new Node(time[1], time[2]));
            nodeToAdjNodesMap.put(time[0], adjNodes);
        }

        for (int i = 1; i <= n; i++) {
            visitedTime[i] = -1;
        }

        queue.add(new Node(k, 0));

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++){
                Node curNode = queue.get(i);

                if (visitedTime[curNode.num] == -1) {
                    visitedTime[curNode.num] = curNode.time;
                } else {
                    visitedTime[curNode.num] = Math.min(visitedTime[curNode.num], curNode.time);
                }

                List<Node> adjNodes = nodeToAdjNodesMap.get(curNode.num);
                if (adjNodes == null) {
                    continue;
                }

                for (Node node : adjNodes) {
                    if (visitedTime[node.num] != -1 && visitedTime[node.num] <= curNode.time + node.time) {
                        continue;
                    }

                    queue.add(new Node(node.num, curNode.time + node.time));
                }
            }

            queue.subList(0, size).clear();
        }

        int minTime = -1;
        for (int i = 1; i <= n; i++) {
            if (visitedTime[i] == -1) {
                return -1;
            }
            minTime = Math.max(minTime, visitedTime[i]);

        }
        return minTime;

    }

    public class Node {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
