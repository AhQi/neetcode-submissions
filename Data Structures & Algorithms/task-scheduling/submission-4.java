class Solution {
    private class Node {
        char symbol;
        int count;
        int time;
        Node(char symbol, int count) {
            this.symbol = symbol;
            this.count = count;
            this.time = 0;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        final PriorityQueue<Node> maxHeap = new PriorityQueue<>((a,b) -> b.count - a.count);
        final Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (hashMap.containsKey(tasks[i])) {
                hashMap.put(tasks[i], hashMap.get(tasks[i]) + 1);
            } else {
                hashMap.put(tasks[i], 1);
            }
        }

        for (Character i : hashMap.keySet()) {
            maxHeap.add(new Node(i, hashMap.get(i)));
        }

        int curTime = 1;
        Queue<Node> queue = new ArrayDeque<>();
        while(maxHeap.size() > 0 || queue.size() > 0) {
            if (queue.size() > 0) {
                Node top = queue.peek();
                if (curTime >= top.time) {
                    queue.poll();
                    maxHeap.add(top);
                }
            }

            if (maxHeap.size() > 0) {
                Node top = maxHeap.poll();
                top.count--;
                System.out.println(curTime + ":" + top.symbol);
                curTime++;
                top.time = curTime + n;
                if (top.count > 0) {
                    queue.offer(top);
                }    
            } else {
                Node top = queue.peek();
                curTime = top.time;
            }
            
        }

        return curTime - 1;
    }
}
