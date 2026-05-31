class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (minHeap.size() > 0 && minHeap.peek() < num) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }

     
    }
    // 1. max: [1]
    // findMedian: 1.0
    // 2. max:[1] min:[3]
    // findMedian (1+3)/2 = 2.0
    // 3. max:[1,2] min:[3]
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return(double) maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return(double) minHeap.peek();
        }

        return ((double) maxHeap.peek() + (double) minHeap.peek())/2.0d;
    }
}
