class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> neighbor = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();
      for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
            }
        }
      for (int i = 0; i < words.length - 1; i++) {
        String next = words[i+1];
        String cur = words[i];
        int minLen = Math.min(next.length(), cur.length());

        if (cur.length() > next.length() && cur.substring(0, minLen).equals(next.substring(0, minLen))) {
          return "";
        }
        for (int j = 0; j < minLen; j++) {
          if (next.charAt(j) != cur.charAt(j)) {
            Set<Character> set =
              neighbor.getOrDefault(cur.charAt(j), new HashSet<>());
            
            if (set.contains(next.charAt(j))) {
              break;
            }
            set.add(next.charAt(j));
            
            neighbor.put(cur.charAt(j), set);

            Integer degree = indegree.getOrDefault(next.charAt(j), 0);
            degree++;
            indegree.put(next.charAt(j), degree);
            break;
          }

          
        }
      }

      Queue<Character> q = new LinkedList<>();
      System.out.println(indegree);
      System.out.println(neighbor);
      for (char c : indegree.keySet()) {
          if (indegree.getOrDefault(c, 0) == 0) {
              q.offer(c);
          }
      }

      String res = "";
      while (!q.isEmpty()) {
        char c = q.poll();
        System.out.println(c);
        res += c;
        Set<Character> s = neighbor.getOrDefault(c, new HashSet<>());
        for (char cc : s) {
          indegree.put(cc, indegree.get(cc) - 1);
          if (indegree.get(cc) == 0) {
            q.offer(cc);
          }
        }
      }

      if (res.length() != indegree.size()) {
          return "";
      }

      return res;
    }
}
