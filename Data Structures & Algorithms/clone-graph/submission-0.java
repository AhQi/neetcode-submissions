/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if (!map.containsKey(cur)) {
                    map.put(cur, new Node(cur.val));
                }

                for (int j = 0; j < cur.neighbors.size(); j++) {
                    if(map.containsKey(cur.neighbors.get(j))) {
                        continue;
                    }
                    queue.add(cur.neighbors.get(j));
                }
            }
        }

        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (visited.containsKey(cur)) {
                    continue;
                }

                visited.put(cur, true);
                Node clone = map.get(cur);
                clone.neighbors = new ArrayList<>();
                

                for (int j = 0; j < cur.neighbors.size(); j++) {
                    Node neighbor = cur.neighbors.get(j);

                    queue.add(neighbor);
                    clone.neighbors.add(map.get(neighbor));
                }
            }
        }

        return map.get(node);
    }
}