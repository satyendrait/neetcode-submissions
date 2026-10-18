class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int w : stones) {
            pq.add(w);
        }

        while (pq.size() > 0) {
            if (pq.size() == 1)
                return pq.remove();
            int x = pq.remove();
            int y = pq.remove();
            if (x != y) {
                pq.add(x - y);
            }
        }
        return 0;
    }
}
