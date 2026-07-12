class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // construct a map of adjacent neignbor nodes.
        // Also record the nodes' indegree/outdegree
        // And run DLS from every node.
        // we can eventualy find a start node, that can visit every node and consumes all the indegree/outdegree.
        Map<String, Map<String, Integer>> nodes = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (nodes.containsKey(ticket.get(0))) {
                Map<String, Integer> tmp = nodes.get(ticket.get(0));
                tmp.put(ticket.get(1), tmp.getOrDefault(ticket.get(1), 0)+1);
            } else {
                Map<String, Integer> tmp = new TreeMap<>();
                tmp.put(ticket.get(1), 1);
                nodes.put(ticket.get(0), tmp);
            }
        }
        List<String> list = new ArrayList<>();
        list.add("JFK");
        return dfs("JFK", nodes, list, tickets.size());
    }

    private List<String> dfs(String cur, Map<String, Map<String, Integer>> nodes, List<String> result, int tickets) {
        if (tickets == 0) {
            return new ArrayList<>(result);
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> tmp = nodes.getOrDefault(cur, new HashMap<>());


        for (Map.Entry<String, Integer> e : tmp.entrySet()) {
            int cnt = e.getValue();
            if (cnt == 0) {
                continue;
            }

            tmp.put(e.getKey(), cnt-1);
            result.add(e.getKey());
            res = dfs(e.getKey(), nodes, result, tickets-1);
            result.remove(result.size() - 1);
            tmp.put(e.getKey(), cnt+1);

            if (res.size() != 0) {
                return res;
            }
        }

        return new ArrayList<>();
    }
}
