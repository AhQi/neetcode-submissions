class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();
      for (String word : words) {
        for (int i = 0; i < word.length(); i++) {
            adj.put(word.charAt(i), new HashSet<>());
            indegree.put(word.charAt(i), 0);
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        String cur = words[i];
        String next = words[i+1];
        int minLen = Math.min(cur.length(), next.length());

        if (cur.length() > next.length() &&
            cur.substring(0, minLen).equals(next.substring(0, minLen))) {
            return "";
        }

        for (int j = 0; j < minLen; j++) {
            if (cur.charAt(j) == next.charAt(j)) {
                continue;
            }

            if (adj.get(cur.charAt(j)).contains(next.charAt(j))) {
                break;
            }

            System.out.println(cur.charAt(j) + ":" + next.charAt(j));
            adj.get(cur.charAt(j)).add(next.charAt(j));
            indegree.put(next.charAt(j), indegree.get(next.charAt(j))+1);
            break;
        }
      }
        System.out.println(adj);
        System.out.println(indegree);
      Queue<Character> q = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        String res = "";
        while(!q.isEmpty()) {
            Character ch = q.poll();
            res += ch;
            for (Character c : adj.get(ch)) {
                indegree.put(c, indegree.get(c)-1);
                if (indegree.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        return res.length() == indegree.size() ? res : "";
    }

      
}
