class KthLargest {
    int size;
    PriorityQueue<Integer> pq = new PriorityQueue();
    public KthLargest(int k, int[] nums) {
        size = k;
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > size) {
            pq.remove();
        }
        return pq.peek();
    }
}
