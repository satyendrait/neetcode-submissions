class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] counts = new int[2001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int indexNum = num + 1000;
            counts[indexNum] = 1 + counts[indexNum];
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                minHeap.add(new Pair(counts[i], i - 1000));
            }
            if (minHeap.size() > k)
                minHeap.poll();
        }
        System.out.print(minHeap);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().num;
        }
        return res;
    }
    class Pair implements Comparable<Pair> {
        int count;
        int num;
        Pair(int count, int num) {
            this.count = count;
            this.num = num;
        }
        public int compareTo(Pair o) {
            if (o == null) {
                throw new NullPointerException("Cannot compare with a null Product");
            }
            return Integer.compare(this.count, o.count);
        }
        public String toString() {
            return "" + count + ", num " + num;
        }
    }
}
