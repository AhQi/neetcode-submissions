class Solution {
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() >= k) {
                if (nums[i] > minHeap.peek()){
                    minHeap.poll();
                } else {
                    continue;
                }
            }
            minHeap.add(nums[i]);
            
        }

        return minHeap.peek();
    }
}
