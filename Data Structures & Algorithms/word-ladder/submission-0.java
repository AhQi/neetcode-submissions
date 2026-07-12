class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new LinkedList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        wordList.add(beginWord);

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String parent = word.substring(0, i) + "*" + word.substring(i+1, word.length());
                if (map.containsKey(parent)) {
                    map.get(parent).add(word);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(word);
                    map.put(parent, set);
                }
            }
        }
        
        queue.offer(beginWord);
        int step = 1;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize > 0) {
                String base = queue.poll();
                visited.add(base);
                System.out.println(step+":"+base);
                if (base.equals(endWord)) {
                    return step;
                }
                for (int i = 0; i < base.length(); i++) {
                    String parent = base.substring(0, i) + "*" + base.substring(i+1, base.length());
                    Set<String> neighbor = map.get(parent);

                    if (neighbor != null) {
                        for (String node : neighbor) {
                            if (visited.contains(node)) {
                                continue;
                            }
                            queue.offer(node);
                        }
                    }
                }
                qSize--;
            }
            step++;
        }

        return 0;
    }
}
