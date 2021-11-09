class Solution {
    public int findKthLargest(int[] nums, int k) {
             //minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i: nums) {
             pq.add(i);
            if(pq.size() > k) {
                pq.remove();
            }
            
        }
        
        // pq now contains k largest elements from nums array
        // returns the smallest element from the k largest elements
        // smallest element pq == kth largest element in nums
        return pq.remove();
    }
}